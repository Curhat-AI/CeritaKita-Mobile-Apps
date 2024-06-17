package com.ceritakita.app.recognition.presentation.screen

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.TitleLarge
import com.ceritakita.app._core.presentation.ui.navigation.NavigationScreen
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app._core.presentation.ui.theme.dmSansFontFamily
import com.ceritakita.app.recognition.presentation.presentation.screens.loading.StatusDialog
import com.ceritakita.app.recognition.presentation.presentation.viewmodel.PredictViewModel
import com.ceritakita.app.recognition.presentation.presentation.viewmodel.PredictionStatus
import com.ceritakita.app.recognition.presentation.screen.self_help.SelfHelpScreen
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextRecognitionScreen(navController: NavController, viewModel: PredictViewModel = hiltViewModel()) {

    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    val imageUri by viewModel.imageUri.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(imageUri) {
        Log.d("TextRecognitionScreen", "imageUri: $imageUri")
    }
    val textPrediction = viewModel.textPrediction.collectAsState().value
    val imagePrediction = viewModel.imagePrediction.collectAsState().value
    val predictionStatus = viewModel.predictionStatus.collectAsState().value

    StatusDialog(status = predictionStatus, onDismiss = { viewModel.clearStatus() })

    LaunchedEffect(predictionStatus) {
        Log.d("TextRecognitionScreen", "Prediction status changed: $predictionStatus")
        if (predictionStatus == PredictionStatus.SUCCESS) {
            navController.navigate("selfHelpScreen")
        }
    }


    Scaffold(
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(WindowInsets.systemBars.asPaddingValues())
        ) {
            TitleLarge(
                text = "Ceritakan tentang keluh kesahmu",
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            BodyLarge(
                text = "Ceritain yuk apa yang kamu rasakan saat ini! Biar kami lebih tau tentang apa yang kamu rasakan",
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Divider(
                thickness = 1.dp,
                color = TextColors.grey200,
                modifier = Modifier.padding(top = 24.dp, bottom = 10.dp)
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 4.dp, vertical = 0.dp),
                value = textFieldValue,
                onValueChange = { newText ->
                    textFieldValue = newText
                },
                textStyle = TextStyle(
                    fontFamily = dmSansFontFamily,
                    fontSize = 16.sp,
                    color = TextColors.grey700,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 16 * 1.5.sp
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                placeholder = { BodyLarge(text = "Ceritain disini yuk..") }
            )
            CustomButton(
                text = "Selanjutnya",
                onClick = {
                    Log.d("TextRecognitionScreen", "Button clicked")
                    val uri = Uri.parse(imageUri)
                    Log.d("TextRecognitionScreen", "Image URI: $uri")
                    val file = getFileFromUri(context, uri)
                    if (file != null && file.exists()) {
                        Log.d("TextRecognitionScreen", "File exists: ${file.path}")
                        val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
                        val body = MultipartBody.Part.createFormData("file", file.name, requestFile)
                        viewModel.predictText(textFieldValue.text)
                        viewModel.predictImage(body)
                    } else {
                        Log.e("TextRecognitionScreen", "File does not exist")
                    }
                },

                modifier = Modifier.padding(horizontal = 16.dp)
            )


        }
    }
}
fun getFileFromUri(context: Context, uri: Uri): File? {
    val contentResolver = context.contentResolver
    val tempFile = File.createTempFile("temp_image", ".jpg", context.cacheDir).apply { deleteOnExit() }
    contentResolver.openInputStream(uri)?.use { inputStream ->
        tempFile.outputStream().use { outputStream ->
            inputStream.copyTo(outputStream)
        }
    }
    return tempFile
}

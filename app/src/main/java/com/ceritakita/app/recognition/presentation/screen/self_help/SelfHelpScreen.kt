package com.ceritakita.app.recognition.presentation.screen.self_help

import CustomAppBar
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.HeadingSmall
import com.ceritakita.app._core.presentation.components.texts.LabelLarge
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app.recognition.presentation.data.constant.SelfHelpData

@Composable
fun SelfHelpScreen(
    navController: NavController,
    emotion: String
) {
    val material = SelfHelpData.selfHelpMaterials[emotion]
    Scaffold(
        contentColor = Color.White,
        topBar = {
            CustomAppBar(
                title = "Materi Self Help",
                onBackClicked = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .verticalScroll(
                    rememberScrollState()
                )
        ) {
            material?.let {
                Image(
                    painter = painterResource(id = it.imageResId),
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    HeadingSmall(text = it.mainTitle)
                    Spacer(modifier = Modifier.height(4.dp))
                    BodyLarge(text = it.mainDescription)
                    Spacer(modifier = Modifier.height(16.dp))

                    it.sessions.forEachIndexed { index, session ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp)
                                .border(
                                    border = BorderStroke(1.dp, color = TextColors.grey200),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .clickable {
                                    navController.navigate("selfHelpDetailScreen/$emotion/$index")
                                }
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                LabelLarge(
                                    text = "Sesi ${index + 1} • ${session.title}",
                                    fontSize = 17.sp
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                BodyLarge(
                                    text = session.description,
                                    maxLines = 3,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            } ?: run {
                BodyLarge(text = "No data available for this emotion.")
            }
        }
    }
}
package com.ceritakita.app.recognition.presentation.screen.self_help

import CustomAppBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.HeadingSmall
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app.recognition.presentation.data.constant.SelfHelpData

@Composable
fun SelfHelpDetailScreen(navController: NavController, emotion: String, sessionIndex: Int) {
    val material = SelfHelpData.selfHelpMaterials[emotion]
    val session = material?.sessions?.getOrNull(sessionIndex)
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
                .padding(16.dp)
                .verticalScroll(
                    rememberScrollState()
                )
        ) {
            session?.let {
                HeadingSmall(
                    text = it.title,
                )
                Spacer(modifier = Modifier.height(10.dp))
                BodyLarge(
                    text = it.description,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 16.sp * 1.6,
                    color = TextColors.grey600
                )
                Spacer(modifier = Modifier.height(32.dp))
                val nextSessionIndex = sessionIndex + 1
                val hasNextSession = nextSessionIndex < (material.sessions.size)
                CustomButton(
                    text = if (hasNextSession) "Selanjutnya" else "Selesai",
                    onClick = {
                        if (hasNextSession) {
                            navController.navigate("selfHelpDetailScreen/$emotion/$nextSessionIndex") {
                                popUpTo("selfHelpDetailScreen/$emotion/$sessionIndex") {
                                    inclusive = true
                                }
                            }
                        } else {
                            navController.navigateUp()
                        }
                    }
                )
            } ?: run {
                BodyLarge(text = "No data available for this session.")
            }
        }
    }
}
package com.ceritakita.app.recognition.presentation.screen.self_help

import CustomAppBar
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.HeadingSmall
import com.ceritakita.app._core.presentation.components.texts.LabelLarge
import com.ceritakita.app._core.presentation.ui.theme.TextColors

@Composable
fun SelfHelpScreen(
    navController: NavController
) {
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
            Image(
                painter = painterResource(id = R.drawable.sample_image),
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
                HeadingSmall(text = "Lorem Ipsum Dolor Sit Amet")
                Spacer(modifier = Modifier.height(4.dp))
                BodyLarge(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.")
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            border = BorderStroke(1.dp, color = TextColors.grey200),
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        LabelLarge(text = "Sesi 1 • Kenalan dengan Stress")
                        Spacer(modifier = Modifier.height(4.dp))
                        BodyLarge(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor")
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            border = BorderStroke(1.dp, color = TextColors.grey200),
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        LabelLarge(text = "Sesi 2 • Mengenali Reaksi dan Pola Stressmu")
                        Spacer(modifier = Modifier.height(4.dp))
                        BodyLarge(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor")
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            border = BorderStroke(1.dp, color = TextColors.grey200),
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        LabelLarge(text = "Sesi 3 • Lorem Ipsum Aja Gak Sih Soalnya Bingung")
                        Spacer(modifier = Modifier.height(4.dp))
                        BodyLarge(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor")
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            border = BorderStroke(1.dp, color = TextColors.grey200),
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        LabelLarge(text = "Sesi 4 • Bang Udah Bang Aku Juga Mau Istirahat")
                        Spacer(modifier = Modifier.height(4.dp))
                        BodyLarge(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor")
                    }
                }
            }
        }
    }
}
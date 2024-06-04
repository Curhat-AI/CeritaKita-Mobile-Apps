package com.ceritakita.app.history.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.LabelMedium
import com.ceritakita.app._core.presentation.components.texts.TitleLarge
import com.ceritakita.app._core.presentation.ui.theme.TextColors

@Composable
fun SelfHelpCard (

) {
    Box {
        Column {
            Image(
                painter = painterResource(id = R.drawable.sample_image),
                contentDescription = "Self Help Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(24.dp))
            TitleLarge(text = "Lorem Ipsum Dolor Sit Amet")
            Spacer(modifier = Modifier.height(4.dp))
            BodyLarge(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua")
            Spacer(modifier = Modifier.height(12.dp))
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
                    LabelMedium(text = "Sesi 1")
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
                    LabelMedium(text = "Sesi 1")
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
                    LabelMedium(text = "Sesi 1")
                    Spacer(modifier = Modifier.height(4.dp))
                    BodyLarge(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor")
                }
            }
        }
    }
}
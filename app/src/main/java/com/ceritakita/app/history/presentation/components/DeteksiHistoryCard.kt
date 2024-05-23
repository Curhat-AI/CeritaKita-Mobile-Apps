package com.ceritakita.app.history.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.components.texts.LabelSmall
import com.ceritakita.app._core.presentation.components.texts.TitleMedium
import com.ceritakita.app._core.presentation.ui.theme.TextColors

@Composable
fun DeteksiHistoryCard(
    imagePainter: Painter,
    textDate: String,
    textTitle: String,
    textDescription: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .border(1.dp, TextColors.grey200, RoundedCornerShape(8.dp))
            .shadow(
                elevation = 10.dp,
                spotColor = Color(0xFF000000).copy(alpha = 0.1f),
                ambientColor = Color(0xFF000000).copy(alpha = 0.1f),
                clip = true
            ),
        shape = RoundedCornerShape(8.dp),
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = imagePainter, contentDescription = "Image Description",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                LabelSmall(
                    text = "Ditulis pada $textDate",
                    color = TextColors.grey400,
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(2.dp))
                TitleMedium(text = textTitle, fontSize = 17.sp, maxLines = 1)
                Spacer(modifier = Modifier.height(4.dp))
                BodyMedium(text = textDescription, color = TextColors.grey600, maxLines = 2)
            }
        }
    }
}
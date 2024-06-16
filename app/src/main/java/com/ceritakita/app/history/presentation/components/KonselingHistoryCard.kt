package com.ceritakita.app.history.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceritakita.app._core.presentation.components.texts.LabelLarge
import com.ceritakita.app._core.presentation.components.texts.LabelMedium
import com.ceritakita.app._core.presentation.components.texts.LabelSmall
import com.ceritakita.app._core.presentation.components.texts.TitleLarge
import com.ceritakita.app._core.presentation.components.texts.TitleMedium
import com.ceritakita.app._core.presentation.ui.theme.AppColors
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors

@Composable
fun KonselingHistoryCard(
    imagePainter: Painter,
    textDate: String,
    textName: String,
    textStatus: String,
    textPrice: String,
    modifier: Modifier = Modifier
) {

    val statusColor = when (textStatus) {
        "Berlangsung" -> AppColors.warningColor
        "Selesai" -> AppColors.successColor
        else -> TextColors.grey700
    }
    Card(
        elevation = 0.dp,
        modifier = Modifier
            .border(1.dp, TextColors.grey200, RoundedCornerShape(8.dp))
            .shadow(
                elevation = 10.dp,
                spotColor = Color(0xFF000000).copy(alpha = 0.1f),
                ambientColor = Color(0xFF000000).copy(alpha = 0.1f),
                clip = true
            ),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = BrandColors.brandPrimary50
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            ) {
            Row(
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
                        text = textDate,
                        color = TextColors.grey400,
                        fontWeight = FontWeight.Normal,
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    TitleMedium(text = textName, fontSize = 17.sp, maxLines = 2)
                    Spacer(modifier = Modifier.height(4.dp))
                    LabelLarge(text = textStatus, color = statusColor, maxLines = 1)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Divider(thickness = 1.dp, color = TextColors.grey200)
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TitleLarge(text = textPrice, color = BrandColors.brandPrimary600)
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = TextColors.grey700,
                        containerColor = Color.Transparent
                    ),
                    shape = CircleShape,
                    border = BorderStroke(1.dp, TextColors.grey300),
                    contentPadding = PaddingValues(horizontal = 20.dp, vertical = 12.dp)
                ) {
                    LabelMedium(text = "Detail Konseling", color = TextColors.grey700)
                }
            }
        }
    }
}
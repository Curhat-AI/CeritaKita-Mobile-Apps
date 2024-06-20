package com.ceritakita.app.profile.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.ui.theme.TextColors

@Composable
fun SettingSectionComponent(
    text: String,
    leftIcon: Painter,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                val y = size.height - strokeWidth / 2
                drawLine(
                    color = TextColors.grey300,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = leftIcon,
                    contentDescription = "Left Icon",
                    modifier = Modifier.size(20.dp),
                    tint = TextColors.grey600
                )
                Spacer(modifier = Modifier.width(10.dp))
                BodyLarge(text = text, color = TextColors.grey700)
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = "Right Icon",
                modifier = Modifier.size(20.dp),
                tint = TextColors.grey700
            )
        }
    }
}
package com.ceritakita.app.history.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.unit.dp
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors

@Composable
fun DottedLine(
    color: Color = TextColors.grey200,
    thickness: Float = 3f,
    dashWidth: Float = 20f,
    gapWidth: Float = 10f,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier.height(thickness.dp)) {
        drawLine(
            color = color,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = 0f),
            strokeWidth = thickness,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashWidth, gapWidth))
        )
    }
}

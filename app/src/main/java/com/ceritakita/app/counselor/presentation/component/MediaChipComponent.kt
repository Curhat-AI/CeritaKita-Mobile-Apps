package com.ceritakita.app.counselor.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.components.texts.BodySmall
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors

@Composable
fun MediaChipRow(
    selectedMediaIndex: Int,
    onMediaClick: (Int) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        MediaChip(
            mediaType = "Voice Call",
            description = "Via WhatsApp",
            icon = R.drawable.ic_voice_call_icon,
            isMediaSelected = selectedMediaIndex == 0,
            onMediaClick = { onMediaClick(0) },
            modifier = Modifier.weight(1f)
        )
        MediaChip(
            mediaType = "Video Call",
            description = "Via WhatsApp",
            icon = R.drawable.ic_video_call_icon,
            isMediaSelected = selectedMediaIndex == 1,
            onMediaClick = { onMediaClick(1) },
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun MediaChip(
    mediaType: String,
    description: String,
    icon: Int,
    isMediaSelected: Boolean,
    onMediaClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        color = if (isMediaSelected) BrandColors.brandPrimary100 else Color.Transparent,
        border = BorderStroke(
            1.dp,
            if (isMediaSelected) BrandColors.brandPrimary600 else TextColors.grey300
        ),
        onClick = onMediaClick
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "$mediaType Icon",
                modifier = Modifier.size(24.dp),
                tint = if (isMediaSelected) BrandColors.brandPrimary600 else TextColors.grey700
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                BodyMedium(
                    text = mediaType,
                    color = if (isMediaSelected) BrandColors.brandPrimary600 else TextColors.grey700,
                    fontWeight = FontWeight.Bold,
                )
                BodySmall(
                    text = description,
                    color = if (isMediaSelected) BrandColors.brandPrimary600 else TextColors.grey500
                )
            }
        }
    }
}

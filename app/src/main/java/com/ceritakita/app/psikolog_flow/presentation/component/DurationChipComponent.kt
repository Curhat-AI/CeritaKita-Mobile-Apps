package com.ceritakita.app.psikolog_flow.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors

@Composable
fun DurationChipRow(
    durations: List<String>,
    selectedIndex: Int,
    onDurationClick: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.Top
    ) {
        durations.forEachIndexed { index, duration ->
            DurationChip(
                duration = duration,
                isDurationSelected = index == selectedIndex,
                onDurationClick = { onDurationClick(index) },
                modifier = Modifier
                    .then(if (durations.size > 3) Modifier.weight(1f) else Modifier.wrapContentWidth())
            )
        }
    }
}

@Composable
fun DurationChip(
    duration: String,
    isDurationSelected: Boolean,
    onDurationClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        color = if (isDurationSelected) BrandColors.brandPrimary100 else Color.Transparent,
        border = BorderStroke(
            1.dp,
            if (isDurationSelected) BrandColors.brandPrimary600 else TextColors.grey300
        ),
        onClick = onDurationClick
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            BodyMedium(
                text = duration,
                color = if (isDurationSelected) BrandColors.brandPrimary600 else TextColors.grey500,
                fontWeight = if (isDurationSelected) FontWeight.SemiBold else FontWeight.Normal,
                textAlign = TextAlign.Center
            )
        }
    }
}
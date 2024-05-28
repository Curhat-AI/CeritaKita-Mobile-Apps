package com.ceritakita.app.psikolog_flow.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors

@Composable
fun DateChipRow(
    days: List<String>,
    dates: List<String>,
    selectedIndex: Int,
    onDateClick: (Int) -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        days.zip(dates).forEachIndexed { index, (day, date) ->
            DateChip(
                day = day,
                date = date,
                isDateSelected = index == selectedIndex,
                onDateClick = { onDateClick(index) },
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}

@Composable
fun DateChip(
    day: String,
    date: String,
    isDateSelected: Boolean,
    onDateClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        color = if (isDateSelected) BrandColors.brandPrimary100 else Color.Transparent,
        border = BorderStroke(
            1.dp,
            if (isDateSelected) BrandColors.brandPrimary600 else TextColors.grey300
        ),
        onClick = onDateClick
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BodyMedium(
                    text = day,
                    color = if (isDateSelected) BrandColors.brandPrimary600 else TextColors.grey500,
                    fontWeight = if (isDateSelected) FontWeight.SemiBold else FontWeight.Normal
                )
                BodyMedium(
                    text = date,
                    color = if (isDateSelected) BrandColors.brandPrimary600 else TextColors.grey500,
                    fontWeight = if (isDateSelected) FontWeight.SemiBold else FontWeight.Normal
                )
            }
        }
    }
}
package com.ceritakita.app.psikolog_flow.presentation.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors

@Composable

fun CheckboxComponent(checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Checkbox(
        modifier = Modifier
            .size(24.dp)
            .scale(1f)
            .padding(0.dp),
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = CheckboxDefaults.colors(
            checkedColor = BrandColors.brandPrimary600,
            uncheckedColor = TextColors.grey400,
            checkmarkColor = Color.White,
            disabledCheckedColor = TextColors.grey500
        )
    )
}
package com.ceritakita.app.counselor.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ceritakita.app._core.presentation.components.texts.LabelLarge
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors

enum class ButtonType {
    Primary, Secondary
}

@Composable
fun AssessmentButtonComponent(
    text: String,
    onClick: () -> Unit,
    buttonType: ButtonType = ButtonType.Primary,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    if (buttonType == ButtonType.Primary) {
        Button(
            onClick = onClick,
            enabled = enabled,
            modifier = modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(100),
            colors = ButtonDefaults.buttonColors(
                containerColor = BrandColors.brandPrimary600,
                contentColor = Color.White,
                disabledContainerColor = TextColors.grey400,
                disabledContentColor = Color.White
            )
        ) {
            LabelLarge(text, color = Color.White, modifier = Modifier.padding(6.dp))
        }
    } else {
        OutlinedButton(
            onClick = onClick,
            enabled = enabled,
            modifier = modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(100),
            border = BorderStroke(1.dp, BrandColors.brandPrimary300),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = BrandColors.brandPrimary600
            )
        ) {
            LabelLarge(text, color = BrandColors.brandPrimary600, modifier = Modifier.padding(6.dp))
        }
    }
}
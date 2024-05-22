package com.ceritakita.app._core.presentation.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceritakita.app._core.presentation.components.texts.LabelMedium
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app._core.presentation.ui.theme.dmSansFontFamily

/**
 * A custom button component in Jetpack Compose that can be styled with an optional icon,
 * custom padding, border radius, and button type.
 *
 * This button allows for primary, secondary, and tertiary button types,
 * each styled to fit the current theme's color scheme.
 *
 * @param text The text to display on the button.
 * @param onClick The callback that is called when the button is tapped.
 * @param icon Optional icon data to display next to the text.
 * @param buttonType The type of the button, which can be [ButtonType.primary], [ButtonType.secondary], or [ButtonType.tertiary].
 * @param padding The padding inside the button, defaulting to symmetric padding of 16.0 dp.
 * @param shape The shape of the button's corners, allowing for custom border radius.
 * @param modifier A [Modifier] for this button to adjust layout or add decoration.
 */

enum class ButtonType { Primary, Secondary, Tertiary }

@Composable
fun CustomButton(
    text: String,
    textButtonColor: Color = Color.White,
    outlineButtonColor: Color? = BrandColors.brandPrimary600,
    onClick: () -> Unit,
    icon: ImageVector? = null,
    buttonType: ButtonType = ButtonType.Primary,
    padding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
    shape: RoundedCornerShape = AppShapes.mediumCorners, // Default shape
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = shape,
        contentPadding = padding,
        colors = ButtonDefaults.buttonColors(
            containerColor = when (buttonType) {
                ButtonType.Primary -> BrandColors.brandPrimary600
                ButtonType.Secondary -> Color.Transparent
                ButtonType.Tertiary -> Color.Transparent
            },
            contentColor = when (buttonType) {
                ButtonType.Primary -> Color.White
                ButtonType.Secondary -> outlineButtonColor ?: BrandColors.brandPrimary600
                ButtonType.Tertiary -> TextColors.grey700
            }
        ),
        border = when (buttonType) {
            ButtonType.Secondary -> BorderStroke(1.dp, BrandColors.brandPrimary600)
            ButtonType.Tertiary -> BorderStroke(1.dp, TextColors.grey300)
            else -> null
        }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            icon?.let {
                Icon(icon, contentDescription = "Button $text", tint= Color.Unspecified
                ) // Assuming you pass a description if needed elsewhere
                LabelMedium(text = " ", modifier = Modifier, color = textButtonColor) // Spacer hack
            }
            LabelMedium(text = text,color = textButtonColor, textAlign = TextAlign.Center, fontFamily = dmSansFontFamily, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    MaterialTheme {
        CustomButton(
            text = "Click Me",
            onClick = {},
            shape = AppShapes.largeCorners // Using large corners for preview
        )
    }
}

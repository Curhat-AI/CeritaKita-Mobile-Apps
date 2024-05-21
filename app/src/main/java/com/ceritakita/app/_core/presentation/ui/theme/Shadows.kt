package com.ceritakita.app._core.presentation.ui.theme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * This object provides a utility to create shadows with various configurations in Jetpack Compose.
 * It allows for the creation of customizable shadow effects applicable on any composable that supports shadow rendering.
 *
 * Usage example:
 * Box(modifier = Modifier.shadow(Shadows.Small)) {
 *   // Your composable content here
 * }
 */
object Shadows {
    /**
     * Creates a shadow with specified color, offset, and blur radius.
     *
     * Parameters:
     * - [color]: The color of the shadow. Default is [Color.Gray].
     * - [offsetX]: The horizontal offset of the shadow. Default is 0.dp.
     * - [offsetY]: The vertical offset of the shadow. Default is 0.dp.
     * - [blurRadius]: The blur radius of the shadow. Default is 0.dp.
     *
     * Returns:
     * - A [Shadow] object that can be applied to composable elements.
     */
    private fun createShadow(color: Color = Color.Gray, offsetX: Dp = 0.dp, offsetY: Dp = 0.dp, blurRadius: Dp = 0.dp): Shadow {
        return Shadow(
            color = color,
            offset = androidx.compose.ui.geometry.Offset(offsetX.value, offsetY.value),
            blurRadius = blurRadius.value
        )
    }

    val FooterShadow: Shadow get() = createShadow(Color(0xFFE6EAEE), 0.dp, 1.dp, 6.dp)
    val CardShadow: Shadow get() = createShadow(Color(0xFFE6EAEE), 0.dp, 4.dp, 32.dp)
    val Large: Shadow get() = createShadow(Color.Gray, 6.dp, 6.dp, 12.dp)
}
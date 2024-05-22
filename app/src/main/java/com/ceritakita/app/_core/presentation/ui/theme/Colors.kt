package com.ceritakita.app._core.presentation.ui.theme
import androidx.compose.ui.graphics.Color

/**
 * This file defines color constants for use in the app's theme.
 *
 * The `TextColors` object contains various shades of grey for text usage.
 * The `BrandColors` object contains different shades of the primary brand color,
 * along with secondary and accent brand colors. The primary brand color is used
 * at 600 intensity.
 * The `AppColors` object defines additional colors for specific purposes such as
 * success, warning, error, and links.
 */

object TextColors {
    val grey900 = Color(0xFF111928)
    val grey800 = Color(0xFF1F2A37)
    val grey700 = Color(0xFF374151)
    val grey600 = Color(0xFF4B5563)
    val grey500 = Color(0xFF6B7280)
    val grey400 = Color(0xFF9CA3AF)
    val grey300 = Color(0xFFD1D5DB)
    val grey200 = Color(0xFFE5E7EB)
    val grey100 = Color(0xFFF3F4F6)
    val grey50 = Color(0xFFF9FAFB)
}

object BrandColors {
    val brandPrimary50 = Color(0xFFF4F6FE)
    val brandPrimary100 = Color(0xFFEAEDFD)
    val brandPrimary200 = Color(0xFFD9DFFB)
    val brandPrimary300 = Color(0xFFBAC3F8)
    val brandPrimary400 = Color(0xFF929CF3)
    val brandPrimary500 = Color(0xFF666CEC)
    val brandPrimary600 = Color(0xFF4845E2)
    val brandPrimary700 = Color(0xFF3833CE)
    val brandPrimary800 = Color(0xFF2F2AAD)
    val brandPrimary900 = Color(0xFF29258D)
    val brandPrimary950 = Color(0xFF191970)
    val brandSecondary = Color(0xFF249EF0)
    val brandAccent = Color(0xFFFF3C8C)
}

object AppColors {
    val successColor = Color(0xFF219653)
    val warningColor = Color(0xFFF2994A)
    val errorColor = Color(0xFFEB5757)
    val linkColor = Color(0xFF2F80ED)
}
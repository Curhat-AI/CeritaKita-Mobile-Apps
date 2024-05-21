package com.ceritakita.app._core.presentation.ui.theme

import android.content.Context

/**
 * This file defines dimension constants for spacing and text size
 * in the app's theme. It utilizes the device's screen dimensions
 * for responsive design.
 */

/**
 * Utility object to convert dp to px and sp to px based on device screen density.
 */
object DimensionUtils {

    /**
     * Converts dp to px.
     * @param context Context to access resources and device-specific display metrics.
     * @param dp Value in dp to convert.
     * @return Converted value in pixels.
     */
    fun dpToPx(context: Context, dp: Float): Float {
        return dp * context.resources.displayMetrics.density
    }

    /**
     * Converts sp to px.
     * @param context Context to access resources and device-specific display metrics.
     * @param sp Value in sp to convert.
     * @return Converted value in pixels.
     */
    fun spToPx(context: Context, sp: Float): Float {
        return sp * context.resources.displayMetrics.scaledDensity
    }
}

object AppSpacing {
    fun xxs(context: Context) = DimensionUtils.dpToPx(context, 2.0f)
    fun xs(context: Context) = DimensionUtils.dpToPx(context, 4.0f)
    fun sm(context: Context) = DimensionUtils.dpToPx(context, 8.0f)
    fun md(context: Context) = DimensionUtils.dpToPx(context, 16.0f)
    fun lg(context: Context) = DimensionUtils.dpToPx(context, 24.0f)
    fun xl(context: Context) = DimensionUtils.dpToPx(context, 32.0f)
    fun xxl(context: Context) = DimensionUtils.dpToPx(context, 40.0f)
}

object AppTextSize {
    fun xxsmall(context: Context) = DimensionUtils.spToPx(context, 12.0f)
    fun xsmall(context: Context) = DimensionUtils.spToPx(context, 13.0f)
    fun small(context: Context) = DimensionUtils.spToPx(context, 14.0f)
    fun medium(context: Context) = DimensionUtils.spToPx(context, 15.0f)
    fun mediumToLarge(context: Context) = DimensionUtils.spToPx(context, 16.0f)
    fun large(context: Context) = DimensionUtils.spToPx(context, 18.0f)
    fun xlarge(context: Context) = DimensionUtils.spToPx(context, 20.0f)
    fun xxlarge(context: Context) = DimensionUtils.spToPx(context, 22.0f)
    fun xxxlarge(context: Context) = DimensionUtils.spToPx(context, 24.0f)
}
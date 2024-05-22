package com.ceritakita.app._core.presentation.components.texts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app._core.presentation.ui.theme.dmSansFontFamily

// Extending each Text Composable with additional parameters for customizability
@Composable
fun HeadingLarge(
    text: String,
    color: Color = TextColors.grey800,
    fontSize: TextUnit = 26.sp,
    fontWeight: FontWeight = FontWeight.Bold,
    fontFamily: FontFamily = dmSansFontFamily,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: androidx.compose.ui.text.style.TextAlign? = null  // Optional text alignment
) {
    Text(
        text = text,
        color = color,
        style = TextStyle(
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
        ),
        modifier = modifier,
        maxLines = maxLines,
        overflow = overflow,
        textAlign = textAlign
    )
}

@Composable
fun HeadingMedium(
    text: String,
    color: Color = TextColors.grey800,
    fontSize: TextUnit = 24.sp,
    fontWeight: FontWeight = FontWeight.Bold,
    fontFamily: FontFamily = dmSansFontFamily,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: androidx.compose.ui.text.style.TextAlign? = null  // Optional text alignment
) {
    Text(
        text = text,
        color = color,
        style = TextStyle(
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
        ),
        modifier = modifier,
        maxLines = maxLines,
        overflow = overflow,
        textAlign = textAlign
    )
}

@Composable
fun HeadingSmall(
    text: String,
    color: Color = TextColors.grey800,
    fontSize: TextUnit = 20.sp,
    fontWeight: FontWeight = FontWeight.Bold,
    fontFamily: FontFamily = dmSansFontFamily,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: androidx.compose.ui.text.style.TextAlign? = null  // Optional text alignment
) {
    Text(
        text = text,
        color = color,
        style = TextStyle(
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
        ),
        modifier = modifier,
        maxLines = maxLines,
        overflow = overflow,
        textAlign = textAlign
    )
}

@Composable
fun TitleLarge(
    text: String,
    color: Color = TextColors.grey800,
    fontSize: TextUnit = 18.sp,
    fontWeight: FontWeight = FontWeight.Bold,
    fontFamily: FontFamily = dmSansFontFamily,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: androidx.compose.ui.text.style.TextAlign? = null  // Optional text alignment
) {
    Text(
        text = text,
        color = color,
        style = TextStyle(
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
        ),
        modifier = modifier,
        maxLines = maxLines,
        overflow = overflow,
        textAlign = textAlign
    )
}

@Composable
fun TitleMedium(
    text: String,
    color: Color = TextColors.grey800,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.Bold,
    fontFamily: FontFamily = dmSansFontFamily,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: androidx.compose.ui.text.style.TextAlign? = null  // Optional text alignment
) {
    Text(
        text = text,
        color = color,
        style = TextStyle(
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
        ),
        modifier = modifier,
        maxLines = maxLines,
        overflow = overflow,
        textAlign = textAlign
    )
}

@Composable
fun TitleSmall(
    text: String,
    color: Color = TextColors.grey800,
    fontSize: TextUnit = 15.sp,
    fontWeight: FontWeight = FontWeight.Bold,
    fontFamily: FontFamily = dmSansFontFamily,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: androidx.compose.ui.text.style.TextAlign? = null  // Optional text alignment
) {
    Text(
        text = text,
        color = color,
        style = TextStyle(
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
        ),
        modifier = modifier,
        maxLines = maxLines,
        overflow = overflow,
        textAlign = textAlign
    )
}

@Composable
fun LabelLarge(
    text: String,
    color: Color = TextColors.grey800,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.SemiBold,
    fontFamily: FontFamily = dmSansFontFamily,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: androidx.compose.ui.text.style.TextAlign? = null  // Optional text alignment
) {
    Text(
        text = text,
        color = color,
        style = TextStyle(
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
        ),
        modifier = modifier,
        maxLines = maxLines,
        overflow = overflow,
        textAlign = textAlign
    )
}

@Composable
fun LabelMedium(
    text: String,
    color: Color = TextColors.grey800,
    fontSize: TextUnit = 14.sp,
    fontWeight: FontWeight = FontWeight.SemiBold,
    fontFamily: FontFamily = dmSansFontFamily,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: androidx.compose.ui.text.style.TextAlign? = null  // Optional text alignment
) {
    Text(
        text = text,
        color = color,
        style = TextStyle(
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
        ),
        modifier = modifier,
        maxLines = maxLines,
        overflow = overflow,
        textAlign = textAlign
    )
}

@Composable
fun LabelSmall(
    text: String,
    color: Color = TextColors.grey800,
    fontSize: TextUnit = 13.sp,
    fontWeight: FontWeight = FontWeight.SemiBold,
    fontFamily: FontFamily = dmSansFontFamily,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: androidx.compose.ui.text.style.TextAlign? = null  // Optional text alignment
) {
    Text(
        text = text,
        color = color,
        style = TextStyle(
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
        ),
        modifier = modifier,
        maxLines = maxLines,
        overflow = overflow,
        textAlign = textAlign
    )
}

@Composable
fun BodyLarge(
    text: String,
    color: Color = TextColors.grey500,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = dmSansFontFamily,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: androidx.compose.ui.text.style.TextAlign? = null  // Optional text alignment
) {
    Text(
        text = text,
        color = color,
        style = TextStyle(
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
        ),
        modifier = modifier,
        maxLines = maxLines,
        overflow = overflow,
        textAlign = textAlign
    )
}

@Composable
fun BodyMedium(
    text: String,
    color: Color = TextColors.grey500,
    fontSize: TextUnit = 15.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = dmSansFontFamily,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: androidx.compose.ui.text.style.TextAlign? = null  // Optional text alignment
) {
    Text(
        text = text,
        color = color,
        style = TextStyle(
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
        ),
        modifier = modifier,
        maxLines = maxLines,
        overflow = overflow,
        textAlign = textAlign
    )
}

@Composable
fun BodySmall(
    text: String,
    color: Color = TextColors.grey500,
    fontSize: TextUnit = 14.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = dmSansFontFamily,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: androidx.compose.ui.text.style.TextAlign? = null  // Optional text alignment
) {
    Text(
        text = text,
        color = color,
        style = TextStyle(
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
        ),
        modifier = modifier,
        maxLines = maxLines,
        overflow = overflow,
        textAlign = textAlign
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewHeadingNormal() {
    Column(modifier = Modifier.padding(16.dp)) {
        HeadingSmall(text = "This is a Heading", color = BrandColors.brandPrimary600)
        HeadingSmall(text = "This is another Heading", color = TextColors.grey700, fontSize = 24.sp)
    }
}
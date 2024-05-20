package com.ceritakita.app.ui.view.main_component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.ceritakita.app.ui.theme.descriptionColor
import com.ceritakita.app.ui.theme.headerColor


// Extending each Text Composable with additional parameters for customizability
@Composable
fun TextBigHeader(
    text: String,
    textColor: Color = headerColor,
    style: TextStyle = typography.headlineLarge.copy(fontSize = 26.sp),
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
    onClick: (() -> Unit)? = null
) {
    Text(
        text = text,
        color = textColor,
        style = style,
        modifier = modifier.clickable(onClick != null) { onClick?.invoke() },
        textAlign = textAlign,
        maxLines = maxLines,
        lineHeight = 5.38.em
    )
}

@Composable
fun TextBigDescription(
    text: String,
    textColor: Color = descriptionColor,
    style: TextStyle = typography.bodyMedium.copy(fontSize = 15.sp),
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
    onClick: (() -> Unit)? = null
) {
    Text(
        text = text,
        color = textColor,
        style = style,
        modifier = modifier.clickable(onClick != null) { onClick?.invoke() },
        textAlign = textAlign,
        maxLines = maxLines,
    )
}

@Composable
fun TextMediumHeader(
    text: String,
    textColor: Color = headerColor,
    style: TextStyle = typography.headlineMedium.copy(fontSize = 22.sp),
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
    onClick: (() -> Unit)? = null
) {
    Text(
        text = text,
        color = textColor,
        style = style,
        modifier = modifier.clickable(onClick != null) { onClick?.invoke() },
        textAlign = textAlign,
        maxLines = maxLines,
        lineHeight = 4.em
    )
}

@Composable
fun TextMediumDescription(
    text: String,
    textColor: Color = descriptionColor,
    style: TextStyle = typography.bodySmall.copy(fontSize = 13.sp),
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
    onClick: (() -> Unit)? = null
) {
    Text(
        text = text,
        color = textColor,
        style = style,
        modifier = modifier.clickable(onClick != null) { onClick?.invoke() },
        textAlign = textAlign,
        maxLines = maxLines,

    )
}

@Composable
fun TextSmallHeader(
    text: String,
    textColor: Color = headerColor,
    style: TextStyle = typography.titleSmall.copy(fontSize = 18.sp),
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
    onClick: (() -> Unit)? = null
) {
    Text(
        text = text,
        color = textColor,
        style = style,
        modifier = modifier.clickable(onClick != null) { onClick?.invoke() },
        textAlign = textAlign,
        maxLines = maxLines,
        lineHeight = 3.em
    )
}

@Composable
fun TextSmallDescription(
    text: String,
    textColor: Color = descriptionColor,
    style: TextStyle = typography.labelSmall.copy(fontSize = 11.sp),
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
    onClick: (() -> Unit)? = null
) {
    Text(
        text = text,
        color = textColor,
        style = style,
        modifier = modifier.clickable(onClick != null) { onClick?.invoke() },
        textAlign = textAlign,
        maxLines = maxLines,
        lineHeight = 5.em
    )
}



@Preview(showBackground = true)
@Composable
fun PreviewTextBigHeader() {
    TextBigHeader(
        text = "This is a Big Header",
        modifier = Modifier.padding(PaddingValues(all = 16.dp))
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTextBigDescription() {
    TextBigDescription(
        text = "This is a Big Description for extended text to showcase styling and layout.",
        modifier = Modifier.padding(PaddingValues(all = 16.dp))
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTextMediumHeader() {
    TextMediumHeader(
        text = "Medium Header Text",
        modifier = Modifier.padding(PaddingValues(all = 16.dp))
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTextMediumDescription() {
    TextMediumDescription(
        text = "Description for the Medium Header which might be a bit longer to demonstrate the effect of styling.",
        modifier = Modifier.padding(PaddingValues(all = 16.dp))
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTextSmallHeader() {
    TextSmallHeader(
        text = "Small Header",
        modifier = Modifier.padding(PaddingValues(all = 16.dp))
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTextSmallDescription() {
    TextSmallDescription(
        text = "This is a small description that accompanies smaller headers.",
        modifier = Modifier.padding(PaddingValues(all = 16.dp))
    )
}
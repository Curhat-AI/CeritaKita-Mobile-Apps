package com.ceritakita.app._core.presentation.components.image_loader

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.transform.Transformation

@Composable
fun ImageFromUrl(
    url: String,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    width: Dp = 128.dp,
    height: Dp = 128.dp,
    padding: Dp = 0.dp,
    placeholder: Painter? = null,
    error: Painter? = null,
    transformations: List<Transformation> = emptyList(),
    colorFilter: ColorFilter? = null,
    crossfade: Boolean = true,
    crossfadeDuration: Int = 300
) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .apply {
                if (crossfade) crossfade(crossfadeDuration)
                transformations(transformations)
            }
            .build(),
        contentDescription = contentDescription,
        loading = {
            CircularProgressIndicator()
        },
        error = {
            error?.let {
                Image(painter = it, contentDescription = contentDescription)
            }
        },
        modifier = modifier
            .width(width)
            .height(height)
            .padding(padding),
        colorFilter = colorFilter
    )
}
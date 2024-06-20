package com.ceritakita.app.history.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ceritakita.app._core.presentation.components.buttons.ButtonType
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.HeadingSmall
import com.ceritakita.app._core.presentation.components.texts.LabelLarge
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app.recognition.presentation.data.constant.SelfHelpData

@Composable
fun SelfHelpCard(
    mainTitle: String,
    mainDescription: String,
    session: SelfHelpData.SelfHelpSession?,
    remainingSessionsCount: Int,
    imageResId: Int,
    onSeeMoreClick: () -> Unit
) {
    Box {
        Column {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Self Help Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(24.dp))
            HeadingSmall(
                text = mainTitle,
                color = TextColors.grey700
            )
            Spacer(modifier = Modifier.height(4.dp))
            BodyLarge(
                text = mainDescription,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                color = TextColors.grey600
            )
            Spacer(modifier = Modifier.height(12.dp))

            session?.let { sess ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            border = BorderStroke(1.dp, color = TextColors.grey200),
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        LabelLarge(text = "Sesi 1 • " + sess.title)
                        Spacer(modifier = Modifier.height(4.dp))
                        BodyLarge(
                            text = sess.description,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            if (remainingSessionsCount > 0) {
                Spacer(modifier = Modifier.height(16.dp))
                CustomButton(
                    text = "Lihat $remainingSessionsCount+ Sesi Lainnya",
                    buttonType = ButtonType.Primary,
                    onClick = onSeeMoreClick,
                    textButtonColor = Color.White,
                    shape = RoundedCornerShape(100.dp)
                )
            }
        }
    }
}

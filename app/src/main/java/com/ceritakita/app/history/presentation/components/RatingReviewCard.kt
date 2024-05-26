package com.ceritakita.app.history.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.buttons.ButtonType
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.components.texts.TitleMedium
import com.ceritakita.app._core.presentation.ui.theme.AppColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors

@Composable
fun RatingReviewCard(
    rating: Int? = null,
    review: String? = null,
    onWriteReviewClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                border = BorderStroke(1.dp, color = TextColors.grey200),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
    ) {
        Column {
            if (rating != null && rating > 0) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    repeat(rating) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star_icon),
                            contentDescription = "Star Icon",
                            modifier = Modifier.size(16.dp),
                            tint = AppColors.warningColor
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    BodyMedium(text = "$rating/5")
                }
                Spacer(modifier = Modifier.height(8.dp))
                review?.let {
                    BodyLarge(text = it, color = TextColors.grey600)
                } ?: Spacer(Modifier.height(0.dp))
            } else {
                BodyLarge(
                    text = "Kamu belum memberi ulasan. Yuk tulis ulasan kamu untuk membantu kami meningkatkan layanan!",
                    color = TextColors.grey600
                )
                Spacer(modifier = Modifier.height(16.dp))
                Divider(thickness = 1.dp, color = TextColors.grey200)
                Spacer(modifier = Modifier.height(16.dp))
                CustomButton(text = "Tulis Ulasan", onClick = onWriteReviewClick, buttonType = ButtonType.Primary, shape = CircleShape)
            }
        }
    }
}
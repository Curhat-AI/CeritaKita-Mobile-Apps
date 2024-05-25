package com.ceritakita.app.history.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.components.texts.TitleMedium
import com.ceritakita.app._core.presentation.ui.theme.TextColors

@Composable
fun KonselingDetailCard (
    counselingSchedule: String = "Counseling Schedule",
    counselingMedia: String = "Counseling Media"
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
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calendar_bold_icon),
                    contentDescription = "Calendar Icon",
                    modifier = Modifier.size(16.dp),
                    tint = TextColors.grey500
                )
                Spacer(modifier = Modifier.width(8.dp))
                BodyMedium(text = "Jadwal Konseling")
            }
            Spacer(modifier = Modifier.height(8.dp))
            TitleMedium(text = counselingSchedule)
            Spacer(modifier = Modifier.height(16.dp))
            Divider(thickness = 1.dp, color = TextColors.grey200)
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_phone_bold_icon),
                    contentDescription = "Phone Icon",
                    modifier = Modifier.size(16.dp),
                    tint = TextColors.grey500
                )
                Spacer(modifier = Modifier.width(8.dp))
                BodyMedium(text = "Media Konseling")
            }
            Spacer(modifier = Modifier.height(8.dp))
            TitleMedium(text = counselingMedia)
        }
    }
}
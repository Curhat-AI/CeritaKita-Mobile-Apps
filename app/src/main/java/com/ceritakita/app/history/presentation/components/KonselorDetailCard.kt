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
fun KonselorDetailCard(
    counselorName: String = "Nama Conselor",
    counselorDetails: String = "Detail Conselor",
    counselorExpertise: String = "Expertise Conselor",
    counselorExperience: String = "Experience Conselor",
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
                    painter = painterResource(id = R.drawable.ic_profile_icon),
                    contentDescription = "Profile Icon",
                    modifier = Modifier.size(16.dp),
                    tint = TextColors.grey500
                )
                Spacer(modifier = Modifier.width(8.dp))
                BodyMedium(text = "Nama Konselor")
            }
            Spacer(modifier = Modifier.height(8.dp))
            TitleMedium(text = counselorName)
            Spacer(modifier = Modifier.height(16.dp))
            Divider(thickness = 1.dp, color = TextColors.grey200)
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_document_icon),
                    contentDescription = "Document Icon",
                    modifier = Modifier.size(16.dp),
                    tint = TextColors.grey500
                )
                Spacer(modifier = Modifier.width(8.dp))
                BodyMedium(text = "Tentang Konselor")
            }
            Spacer(modifier = Modifier.height(8.dp))
            BodyLarge(text = counselorDetails, color = TextColors.grey600)
            Spacer(modifier = Modifier.height(16.dp))
            Divider(thickness = 1.dp, color = TextColors.grey200)
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_verified_icon),
                    contentDescription = "Verified Icon",
                    modifier = Modifier.size(16.dp),
                    tint = TextColors.grey500
                )
                Spacer(modifier = Modifier.width(8.dp))
                BodyMedium(text = "Expertise")
            }
            Spacer(modifier = Modifier.height(8.dp))
            BodyLarge(text = counselorExpertise, color = TextColors.grey600)
            Spacer(modifier = Modifier.height(16.dp))
            Divider(thickness = 1.dp, color = TextColors.grey200)
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_work_icon),
                    contentDescription = "Work Icon",
                    modifier = Modifier.size(16.dp),
                    tint = TextColors.grey500
                )
                Spacer(modifier = Modifier.width(8.dp))
                BodyMedium(text = "Pengalaman")
            }
            Spacer(modifier = Modifier.height(8.dp))
            BodyLarge(text = counselorExperience, color = TextColors.grey600)
        }
    }
}
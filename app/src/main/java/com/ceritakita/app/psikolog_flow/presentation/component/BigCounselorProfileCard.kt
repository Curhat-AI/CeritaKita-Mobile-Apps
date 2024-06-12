package com.ceritakita.app.psikolog_flow.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.components.texts.BodySmall
import com.ceritakita.app._core.presentation.components.texts.LabelLarge
import com.ceritakita.app._core.presentation.components.texts.TitleLarge
import com.ceritakita.app._core.presentation.ui.theme.AppColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app.psikolog_flow.data.Profile

@Composable
fun BigCounselorProfileCard(profile: Profile) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 32.dp,
                spotColor = Color(0x0F000000),
                ambientColor = Color(0x0F000000)
            )
            .border(1.dp, TextColors.grey100, RoundedCornerShape(8.dp)),
        colors = CardColors(
            disabledContainerColor = Color.White,
            containerColor = Color.White,
            disabledContentColor = Color.White,
            contentColor = Color.White
        ),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Column(
                    modifier = Modifier.padding(start = 10.dp),
                ) {
                    TitleLarge(
                        text = "${profile.name}, ${profile.degree}", fontSize = 20.sp, maxLines = 2,
                    )
                    Row(
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        Row {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_work_icon),
                                contentDescription = "Work Experience",
                                modifier = Modifier.size(16.dp),
                                tint = AppColors.warningColor
                            )
                            BodySmall(
                                text = "${profile.yearsExperience} Tahun",
                                modifier = Modifier.padding(start = 4.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Row {
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_star_icon),
                                    contentDescription = "Rating",
                                    modifier = Modifier.size(16.dp),
                                    tint = AppColors.warningColor
                                )
                                BodySmall(
                                    text = "${profile.rating}",
                                    modifier = Modifier.padding(start = 4.dp)
                                )
                            }
                        }
                    }
                }
            }
            BodyMedium(
                modifier = Modifier
                    .padding(top = 12.dp, end = 16.dp),
                textAlign = TextAlign.Start,
                text = "Expert in ${profile.expertise}",
            )
            Row(
                modifier = Modifier.padding(top = 12.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {
                LabelLarge(
                    modifier = Modifier
                        .padding(end = 4.dp),
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    text = "Jadwal Tersedia:",
                )
                BodyLarge(
                    textAlign = TextAlign.Start,
                    text = "Hari ini",
                )
            }
            Row(modifier = Modifier.padding(top = 10.dp)) {
                TimeChip(time = "12:00")
                TimeChip(time = "14:00")
                TimeChip(time = "16:00")
            }
        }
    }
}

@Composable
fun TimeChip(time: String) {
    Card(
        modifier = Modifier
            .padding(end = 6.dp)
            .border(1.dp, TextColors.grey200, RoundedCornerShape(4.dp)),
        colors = CardColors(
            disabledContainerColor = Color.White,
            containerColor = Color.White,
            disabledContentColor = Color.White,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(4.dp),
    ) {
        BodySmall(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            text = time,
            fontWeight = FontWeight.Medium,
            color = TextColors.grey700
        )
    }
}
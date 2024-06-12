package com.ceritakita.app.counselor.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.components.texts.BodySmall
import com.ceritakita.app._core.presentation.components.texts.TitleLarge
import com.ceritakita.app._core.presentation.ui.theme.AppColors
import com.ceritakita.app.counselor.data.Profile

@Composable
fun MiniCounselorProfileCard(profile: Profile) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(top = 16.dp)
            .width(200.dp)
            .shadow(
                elevation = 32.dp,
                spotColor = Color(0x0F000000),
                ambientColor = Color(0x0F000000)
            ),
        colors = CardColors(
            disabledContainerColor = Color.White,
            containerColor = Color.White,
            disabledContentColor = Color.White,
            contentColor = Color.White
        ),
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Profile Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(172.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(horizontal = 10.dp)
            ) {
                TitleLarge(
                    text = "${profile.name}, ${profile.degree}",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(4.dp))
                BodyMedium(
                    text = "Expert in ${profile.expertise}",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                Row(
                    modifier = Modifier.padding(top = 12.dp, bottom = 10.dp)
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
    }
}
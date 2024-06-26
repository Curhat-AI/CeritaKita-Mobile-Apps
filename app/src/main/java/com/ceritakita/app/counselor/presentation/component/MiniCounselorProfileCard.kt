package com.ceritakita.app.counselor.presentation.component

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.components.texts.BodySmall
import com.ceritakita.app._core.presentation.components.texts.TitleLarge
import com.ceritakita.app._core.presentation.ui.theme.AppColors
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app.counselor.domain.entities.CounselorProfileEntities

@Composable
fun MiniCounselorProfileCard(counselorProfileEntities: CounselorProfileEntities, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(top = 16.dp)
            .width(200.dp)
            .clickable(onClick = onClick)
            .shadow(
                elevation = 32.dp,
                spotColor = Color(0x0F000000),
                ambientColor = Color(0x0F000000)
            ),
        colors = CardColors(
            disabledContainerColor = BrandColors.brandPrimary50,
            containerColor = BrandColors.brandPrimary50,
            disabledContentColor = BrandColors.brandPrimary50,
            contentColor = BrandColors.brandPrimary50
        ),
    ) {
        Column {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(counselorProfileEntities.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "Image",
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
                    text = counselorProfileEntities.name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(4.dp))
                BodyMedium(
                    text = "Expert in ${counselorProfileEntities.expertise}",
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
                            text = "${counselorProfileEntities.experienceYears} Tahun",
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
                                text = "${counselorProfileEntities.experienceYears}",
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
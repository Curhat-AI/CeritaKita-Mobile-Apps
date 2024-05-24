package com.ceritakita.app.template_feature.presentation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.buttons.ButtonType
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.texts.BodySmall
import com.ceritakita.app._core.presentation.components.texts.HeadingLarge
import com.ceritakita.app._core.presentation.components.texts.LabelLarge
import com.ceritakita.app._core.presentation.components.texts.LabelMedium
import com.ceritakita.app._core.presentation.components.texts.LabelSmall
import com.ceritakita.app._core.presentation.ui.theme.TextColors

@Composable
fun CounselorDetailScreen(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
    ){

        Column(
            modifier = Modifier

                .padding(WindowInsets.systemBars.asPaddingValues())
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp),
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Button Back",
                )
                Spacer(modifier = Modifier.widthIn(16.dp))
                LabelMedium(text = "Profil Psikolog", color = TextColors.grey700)
            }

        }
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Profile Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .align(Alignment.CenterHorizontally)
        )
        Column(modifier = Modifier                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            HeadingLarge(
                text = "Profil Psikolog",
                fontSize = 22.sp,
            )
            Row(
                modifier = Modifier.padding(top = 12.dp, bottom = 10.dp)
            ){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_work_icon),
                        contentDescription = "Rating",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "4.3",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Rating",
                        modifier = Modifier.size(24.dp),

                        )
                    Text(
                        text = "6 Tahun",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
            BodySmall(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                color = TextColors.grey500, )
            Spacer(modifier = Modifier.padding(vertical = 20.dp))
            HeadingLarge(
                text = "Spesialisasi",
                fontSize = 18.sp,
            )
            Spacer(modifier = Modifier.padding(vertical = 2.dp))

            BodySmall(text = "Pekerjaan, Percintaan, Positif Psikologi, Karir, Mindfulness, Person Center Therapy (PCT)",
                color = TextColors.grey500, )
            Divider(thickness = 1.dp, color = TextColors.grey200, modifier = Modifier.padding(vertical = 20.dp))
            HeadingLarge(
                text = "Jadwal Tersedia",
                fontSize = 18.sp,
            )
            Spacer(modifier = Modifier.padding(vertical = 2.dp))
            Row {
                DateChip(date = "Minggu 19 Mei", isSelected = true)
                DateChip(date = "Senin 20 Mei")
                DateChip(date = "Senin 20 Mei")
                DateChip(date = "Mei", isSelected = true)  // Assuming this chip is selected for demonstration
            }
            HeadingLarge(
                text = "Waktu Tersedia",
                fontSize = 18.sp,
            )
            Spacer(modifier = Modifier.padding(vertical = 2.dp))
            Row {
                DateChip(date = "14:00 WIB", isSelected = true)
                DateChip(date = "16:00 WIB")
            }
            Spacer(modifier = Modifier.padding(vertical = 10.dp))

            CustomButton(text = "Masuk", onClick = { /*TODO*/ }, buttonType = ButtonType.Primary)

        }

    }
}
@Composable
fun bottomSheet(){
    Column {
        HeadingLarge(
            text = "Konfirmasi Jadwal & Media Konseling",
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.padding(vertical = 2.dp))

        BodySmall(text = "Pastikan jadwal yang kamu pilih sudah sesuai",
            color = TextColors.grey500, )

        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        HeadingLarge(
            text = "Waktu Dipilih",
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.padding(vertical = 2.dp))
        Row {
            DateChip(date = "Minggu 19 Mei", isSelected = true)
            DateChip(date = "Senin 20 Mei")
            DateChip(date = "Senin 20 Mei")
            DateChip(date = "Mei", isSelected = true)  // Assuming this chip is selected for demonstration
        }

        HeadingLarge(
            text = "Durasi Konseling",
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.padding(vertical = 2.dp))
        Row {
            DateChip(date = "30 Menit", isSelected = true)
            DateChip(date = "1 Jam")
            // Assuming this chip is selected for demonstration
        }

    }
}
@Composable
fun DateChip(
    date: String,
    isSelected: Boolean = false,
    onClick: () -> Unit = {}
) {
    Surface(
        modifier = Modifier.padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else Color.White,
        border = BorderStroke(1.dp, if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray),
        shadowElevation = if (isSelected) 4.dp else 0.dp,
        onClick = onClick
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Text(
                text = date,
                color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else Color.Black,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDateChips() {
    Row {
        DateChip(date = "Minggu 19 Mei", isSelected = true)
        DateChip(date = "Senin 20 Mei")
        DateChip(date = "Senin 20 Mei")
        DateChip(date = "Mei", isSelected = true)  // Assuming this chip is selected for demonstration
    }
}
@Preview(showSystemUi = false, showBackground = true)
@Composable
fun PreviewCounselorDetail() {
    CounselorDetailScreen(navController = rememberNavController())
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun PreviewSheet() {
    bottomSheet()
}
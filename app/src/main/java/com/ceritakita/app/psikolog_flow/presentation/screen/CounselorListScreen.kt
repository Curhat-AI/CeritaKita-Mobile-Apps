package com.ceritakita.app.psikolog_flow.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.HeadingLarge
import com.ceritakita.app._core.presentation.ui.navigation.NavigationScreen
import com.ceritakita.app._core.presentation.ui.theme.AppColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app.template_feature.data.Profile

val profiles = listOf(
    Profile(
        name = "Yanuar Tri Laksono",
        degree = "M.Psi",
        expertise = "Coding",
        imageUrl = "https://example.com/profile1.jpg",
        yearsExperience = 6,
        rating = 4.5
    ),
    Profile(
        name = "Aulia Rahmi",
        degree = "Ph.D.",
        expertise = "Machine Learning",
        imageUrl = "https://example.com/profile2.jpg",
        yearsExperience = 4,
        rating = 4.8
    ),
    Profile(
        name = "Irfan Budi",
        degree = "M.Tech",
        expertise = "Data Science",
        imageUrl = "https://example.com/profile3.jpg",
        yearsExperience = 8,
        rating = 4.7
    ),
    Profile(
        name = "Sari Puspita",
        degree = "B.Sc",
        expertise = "Web Development",
        imageUrl = "https://example.com/profile4.jpg",
        yearsExperience = 5,
        rating = 4.6
    ),
    Profile(
        name = "Tommy Saputra",
        degree = "M.Com",
        expertise = "Digital Marketing",
        imageUrl = "https://example.com/profile5.jpg",
        yearsExperience = 3,
        rating = 4.3
    )
)


@Composable
fun ProfileList(profiles: List<Profile>) {
    LazyRow(
        contentPadding = PaddingValues(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(profiles) { profile ->
            ProfileCard(profile = profile)
        }
    }
}

@Composable
fun CounselorListScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            BodyLarge(
                text = "Konsultasi Psikolog",
                textAlign = TextAlign.Start,
                color = TextColors.grey600
            )
            Icon(
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp),
                painter = painterResource(id = R.drawable.ic_search_icon),
                contentDescription = "Button Search",
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 16.dp)

        ) {
            HeadingLarge(
                text = "Rekomendasi Untukmu",
                fontSize = 24.sp,
            )
            BodyLarge(
                text = "Semua",
                fontWeight = FontWeight.Medium,
                color = AppColors.linkColor
            )
        }
        Spacer(modifier = Modifier.heightIn(4.dp))
        BodyLarge(
            text = "Psikolog sebaya dan cocok dengan keadaanmu",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            color = TextColors.grey600
        )
        ProfileList(profiles = profiles)
//        Row(
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier.padding(top = 16.dp)
//
//        ){
//            HeadingLarge(
//                text = "Spesialis di Pendidikan",
//                fontSize = 24.sp,
//            )
//            BodyLarge(
//                text = "Semua",
//                fontWeight = FontWeight.Medium,
//                color = AppColors.linkColor
//            )
//        }
//        Spacer(modifier = Modifier.heightIn(4.dp))
//        ProfileList(profiles = profiles)
        Spacer(modifier = Modifier.heightIn(24.dp))

        HeadingLarge(
            text = "Semua Konselor",
            fontSize = 24.sp,
        )
        ProfileCardHorizontal(
            profile = Profile(
                name = "Yanuar Tri Laksono",
                degree = "M.Psi",
                expertise = "Coding",
                imageUrl = "https://example.com/profile.jpg", // Replace with actual image URL
                yearsExperience = 6,
                rating = 4.5
            )
        )

    }
}

@Composable
fun ProfileCard(profile: Profile) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .height(320.dp)

            .padding(top = 16.dp)
    ) {
        Column(
            modifier = Modifier.width(200.dp)
        ) {
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
                Text(
                    text = "${profile.name}, ${profile.degree}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Expert in ${profile.expertise}",
                    fontSize = 14.sp
                )
                Row(
                    modifier = Modifier.padding(top = 12.dp, bottom = 10.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_work_icon),
                            contentDescription = "Rating",
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "${profile.rating} (${profile.yearsExperience} Tahun)",
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
                            text = "${profile.rating}",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }
            }


        }
    }
}

@Composable
fun ProfileCardHorizontal(profile: Profile) {
    Card(
        shape = RoundedCornerShape(8.dp), modifier = Modifier.padding(top = 10.dp)
    )
    {

        Row(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Profile Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(79.dp)
                    .height(79.dp)

            )
            Column(
                modifier = Modifier.padding(start = 10.dp),
            ) {
                Text(
                    text = "${profile.name}, ${profile.degree}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier.padding(top = 12.dp, bottom = 10.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_work_icon),
                            contentDescription = "Rating",
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "${profile.rating} (${profile.yearsExperience} Tahun)",
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
                            text = "${profile.rating}",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                }

            }

        }
        Text(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Start,
            text = "Expert di depression, keuangan dan karir. 6 tahun berpengalaman di psikolog ${profile.expertise}",
            fontSize = 14.sp
        )
        Row(
            modifier = Modifier.padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                modifier = Modifier
                    .padding(start = 16.dp, end = 5.dp),
                textAlign = TextAlign.Start,
                text = "Jadwal Tersedia:",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                textAlign = TextAlign.Start,
                text = "Hari ini",
                fontSize = 14.sp
            )
        }
        Row(modifier = Modifier.padding(start = 16.dp, top = 8.dp)) {
            TimeChip(time = "12:00")
            TimeChip(time = "14:00")
            TimeChip(time = "16:00")
        }
        Spacer(modifier = Modifier.height(10.dp))

    }
}

@Composable
fun TimeChip(time: String) {

    Box(modifier = Modifier.padding(horizontal = 5.dp)) {
        Surface(
            modifier = Modifier
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
            color = Color.White,
            shadowElevation = 2.dp,
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = time,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
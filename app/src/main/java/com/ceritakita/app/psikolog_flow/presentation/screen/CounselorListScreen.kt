package com.ceritakita.app.psikolog_flow.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.HeadingSmall
import com.ceritakita.app._core.presentation.ui.theme.AppColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app.psikolog_flow.data.Profile
import com.ceritakita.app.psikolog_flow.presentation.component.BigCounselorProfileCard
import com.ceritakita.app.psikolog_flow.presentation.component.MiniCounselorProfileCard

val profiles = listOf(
    Profile(
        name = "Yanuar Tri Laksono",
        degree = "M.Psi",
        expertise = "keuangan dan karir",
        imageUrl = "https://example.com/profile1.jpg",
        yearsExperience = 6,
        rating = 4.5
    ),
    Profile(
        name = "Aulia Rahmi",
        degree = "Ph.D.",
        expertise = "keuangan dan karir",
        imageUrl = "https://example.com/profile2.jpg",
        yearsExperience = 4,
        rating = 4.8
    ),
    Profile(
        name = "Irfan Budi",
        degree = "M.Tech",
        expertise = "keuangan dan karir",
        imageUrl = "https://example.com/profile3.jpg",
        yearsExperience = 8,
        rating = 4.7
    ),
    Profile(
        name = "Sari Puspita",
        degree = "B.Sc",
        expertise = "keuangan dan karir",
        imageUrl = "https://example.com/profile4.jpg",
        yearsExperience = 5,
        rating = 4.6
    ),
    Profile(
        name = "Tommy Saputra",
        degree = "M.Com",
        expertise = "keuangan dan karir",
        imageUrl = "https://example.com/profile5.jpg",
        yearsExperience = 3,
        rating = 4.3
    )
)

@Composable
fun CounselorListScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 16.dp).fillMaxWidth()

        ) {
            HeadingSmall(
                text = "Rekomendasi Untukmu",
                fontSize = 22.sp
            )
            BodyLarge(
                text = "Semua",
                fontWeight = FontWeight.Medium,
                color = AppColors.linkColor
            )
        }
        Spacer(modifier = Modifier.heightIn(2.dp))
        BodyLarge(
            text = "Psikolog sebaya dan cocok dengan keadaanmu",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            color = TextColors.grey600
        )
        RowProfileList(profiles = profiles)
        Spacer(modifier = Modifier.heightIn(24.dp))
        HeadingSmall(
            text = "Semua Konselor",
            fontSize = 22.sp,
        )
        profiles.forEach { profile ->
            BigCounselorProfileCard(profile)
        }
    }
}

@Composable
fun RowProfileList(profiles: List<Profile>) {
    LazyRow(
        contentPadding = PaddingValues(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(profiles) { profile ->
            MiniCounselorProfileCard(profile = profile)
        }
    }
}
package com.ceritakita.app.counselor.presentation.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.HeadingSmall
import com.ceritakita.app._core.presentation.ui.theme.AppColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app.counselor.domain.entities.CounselorProfileEntities
import com.ceritakita.app.counselor.presentation.component.BigCounselorProfileCard
import com.ceritakita.app.counselor.presentation.component.MiniCounselorProfileCard
import com.ceritakita.app.counselor.presentation.viewmodel.CounselorListViewModel

@Composable
fun CounselorListScreen(navController: NavController, viewModel: CounselorListViewModel = hiltViewModel()) {
    val profiles by viewModel.profiles.observeAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()

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
        RowProfileList(
            counselorProfileEntities = profiles,
            onCounselorClick = { counselorId ->
                Log.d("CounselorListScreen", "Navigating to counselorDetail with ID: $counselorId")
                navController.navigate("counselorDetailScreen/$counselorId")
            }
        )
//        Button(onClick = { navController.navigate("paymentScreen") }) {
//
//        }
        Spacer(modifier = Modifier.heightIn(24.dp))
        HeadingSmall(
            text = "Semua Konselor",
            fontSize = 22.sp,
        )
        profiles.forEach { profile ->
            BigCounselorProfileCard(profile) { counselorId ->
                Log.d("CounselorListScreen", "Navigating to counselorDetail with ID: $counselorId")
                navController.navigate("counselorDetailScreen/$counselorId")
            }
        }
    }
}

@Composable
fun RowProfileList(
    counselorProfileEntities: List<CounselorProfileEntities>,
    onCounselorClick: (String) -> Unit // Add the callback function for counselor clicks
) {
    LazyRow(
        contentPadding = PaddingValues(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(counselorProfileEntities) { profile ->
            MiniCounselorProfileCard(
                counselorProfileEntities = profile,
                onClick = { onCounselorClick(profile.id) }  // Pass the onClick to the card
            )
        }
    }
}
package com.ceritakita.app.homepage.presentation.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.components.texts.HeadingSmall
import com.ceritakita.app._core.presentation.components.texts.TitleLarge
import com.ceritakita.app._core.presentation.ui.theme.AppColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app.counselor.presentation.screen.RowProfileList
import com.ceritakita.app.counselor.presentation.viewmodel.CounselorListViewModel
import com.ceritakita.app.homepage.presentation.component.TestActionCard

@Composable
fun HomeScreen(navController: NavController, viewModel: CounselorListViewModel = hiltViewModel()) {
    val profiles by viewModel.profiles.observeAsState(initial = emptyList())
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top = 10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://picsum.photos/600")
                    .crossfade(true)
                    .transformations(CircleCropTransformation())
                    .build(),
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(56.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                TitleLarge(text = "Alexander Kahfi")
                BodyMedium(text = "Gimana harimu berjalan, Kahfi?")
            }
        }
        Spacer(modifier = Modifier.heightIn(20.dp))
        TitleLarge(
            text = "DISINI HARUSNYA ADA GRAFIK, TAPI AKU BINGUNG BJIRR",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Divider(
            color = TextColors.grey100,
            thickness = 6.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
        )
        TestActionCard(onClick = { /*TODO*/ }, modifier = Modifier.padding(horizontal = 20.dp))
        Divider(
            color = TextColors.grey100,
            thickness = 6.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
        )
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
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
                    Log.d(
                        "CounselorListScreen",
                        "Navigating to counselorDetail with ID: $counselorId"
                    )
                    navController.navigate("counselorDetailScreen/$counselorId")
                }
            )
        }
    }
}
package com.ceritakita.app.history.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.tabBar.CustomTabBar
import com.ceritakita.app.history.presentation.components.DeteksiHistoryCard
import com.ceritakita.app.history.presentation.components.KonselingHistoryCard
import com.ceritakita.app.history.presentation.viewmodel.CounselingHistoryViewModel
import com.ceritakita.app.history.presentation.viewmodel.EmotionDetectionHistoryViewModel
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun HistoryScreen(
    navController: NavController,
    emotionViewModel: EmotionDetectionHistoryViewModel = hiltViewModel(),
    counselingViewModel: CounselingHistoryViewModel = hiltViewModel()
) {
    val userId = "CdURxrK7LYOdRD8nrm3273U7O5E2"
    val tabs = listOf("Deteksi", "Konseling")
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    LaunchedEffect(key1 = userId) {
        emotionViewModel.loadEmotionHistories(userId)
        counselingViewModel.loadCounselingHistories(userId)
    }

    Column(
        modifier = Modifier.statusBarsPadding(),
    ) {
        CustomTabBar(
            tabs = tabs,
            selectedTabIndex = selectedTabIndex,
            onTabSelected = { selectedTabIndex = it })
        TabContent(index = selectedTabIndex, emotionViewModel = emotionViewModel, counselingViewModel = counselingViewModel, navController)
    }
}

@Composable
fun TabContent(index: Int, emotionViewModel: EmotionDetectionHistoryViewModel, counselingViewModel: CounselingHistoryViewModel, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        when (index) {
            0 -> TabOneContent(emotionViewModel)
            1 -> TabTwoContent(counselingViewModel, navController)
        }
    }
}

@Composable
fun TabOneContent(viewModel: EmotionDetectionHistoryViewModel) {
    val emotionHistories by viewModel.emotionHistories.observeAsState(emptyList())

    if (emotionHistories.isEmpty()) {
        CircularProgressIndicator()
    } else {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        ) {
            emotionHistories.forEach { emotion ->
                DeteksiHistoryCard(
                    imagePainter = painterResource(id = R.drawable.sample_image),
                    textDate = emotion.detectionTime?.let {
                        SimpleDateFormat("HH:mm, dd MMM yyyy", Locale.getDefault()).format(it)
                    } ?: "",
                    textTitle = emotion.emotion,
                    textDescription = emotion.emotion
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun TabTwoContent(viewModel: CounselingHistoryViewModel, navController: NavController) {
    val counselingHistories by viewModel.counselingHistories.observeAsState(emptyList())
    val counselors by viewModel.counselors.observeAsState(emptyMap())

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        counselingHistories.forEach { history ->
            val counselor = counselors[history.counselorId]
            KonselingHistoryCard(
                imagePainter = painterResource(id = R.drawable.sample_image),
                textDate = history.startTime?.let {
                    SimpleDateFormat("dd MMM yyyy • HH:mm", Locale.getDefault()).format(it)
                } ?: "Unknown date",
                textName = counselor?.name ?: "Loading counselor...",
                textStatus = history.status,
                textPrice = "Rp 50.000", // Placeholder for actual pricing
                onClick = { navController.navigate("counselingDetailScreen/${history.sessionId}") }
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTabBarWithScrollableContent() {
    HistoryScreen(navController = rememberNavController())
}
package com.ceritakita.app.history.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.tabBar.CustomTabBar
import com.ceritakita.app.counselor.domain.states.EmotionHistoryState
import com.ceritakita.app.history.presentation.components.DeteksiHistoryCard
import com.ceritakita.app.history.presentation.components.KonselingHistoryCard
import com.ceritakita.app.history.presentation.viewmodel.EmotionDetectionHistoryViewModel
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun HistoryScreen(navController: NavController, viewModel: EmotionDetectionHistoryViewModel = viewModel()) {
    val userId = "CdURxrK7LYOdRD8nrm3273U7O5E2"
    val tabs = listOf("Deteksi", "Konseling")
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(key1 = userId) {
        viewModel.loadEmotionHistory(userId)
    }

    Column(
        modifier = Modifier.statusBarsPadding(),
    ) {
        CustomTabBar(
            tabs = tabs,
            selectedTabIndex = selectedTabIndex,
            onTabSelected = { selectedTabIndex = it })
        TabContent(index = selectedTabIndex, viewModel = viewModel)
    }
}

@Composable
fun TabContent(index: Int, viewModel: EmotionDetectionHistoryViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        when (index) {
            0 -> TabOneContent(viewModel)
            1 -> TabTwoContent()
        }
    }
}

@Composable
fun TabOneContent(viewModel: EmotionDetectionHistoryViewModel) {
    val emotionHistoryState by viewModel.emotionHistoryState.observeAsState()

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        when (emotionHistoryState) {
            EmotionHistoryState.Loading -> {
                CircularProgressIndicator()
            }
            is EmotionHistoryState.Success -> {
                (emotionHistoryState as EmotionHistoryState.Success).data.forEach { emotion ->
                    DeteksiHistoryCard(
                        imagePainter = painterResource(id = R.drawable.sample_image),
                        // Ganti dengan logika untuk menampilkan gambar yang sesuai
                        textDate = emotion.detectionTime?.toDate()?.let {
                            SimpleDateFormat("HH:mm, dd MMM yyyy", Locale.getDefault()).format(it)
                        } ?: "",
                        textTitle = emotion.emotion,
                        textDescription = emotion.emotion
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
            is EmotionHistoryState.Error -> {
                Text("Failed to load data: ${(emotionHistoryState as EmotionHistoryState.Error).message}")
            }
            else -> {
                Text("Loading or no data available")
            }
        }
    }
}




@Composable
fun TabTwoContent() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        repeat(30) {
            KonselingHistoryCard(
                imagePainter = painterResource(id = R.drawable.sample_image),
                textDate = "18 Mei 2024 • 14:00",
                textName = "Yanuar Tri Laksono, M.Psi, Psikolog",
                textStatus = "Berlangsung",
                textPrice = "Rp 50.000"
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
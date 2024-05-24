package com.ceritakita.app.history.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.buttons.ButtonType
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.tabBar.CustomTabBar
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app.history.presentation.components.DeteksiHistoryCard
import com.ceritakita.app.history.presentation.components.KonselingHistoryCard

@Composable
fun HistoryScreen(navController: NavController) {
    val tabs = listOf("Deteksi", "Konseling")
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues())
    ) {
        CustomTabBar(
            tabs = tabs,
            selectedTabIndex = selectedTabIndex,
            onTabSelected = { selectedTabIndex = it })
        TabContent(index = selectedTabIndex)
    }
}

@Composable
fun TabContent(index: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        when (index) {
            0 -> TabOneContent()
            1 -> TabTwoContent()
        }
    }
}

@Composable
fun TabOneContent() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        repeat(30) {
            DeteksiHistoryCard(
                imagePainter = painterResource(id = R.drawable.sample_image),
                textDate = "18:40",
                textTitle = "Cemas dan Khawatir",
                textDescription = "but i'm only human after all. don't put your blame on me, ohhh",
            )
            Spacer(modifier = Modifier.height(10.dp))
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
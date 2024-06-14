package com.ceritakita.app._core.presentation.ui.navigation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.components.texts.BodySmall
import com.ceritakita.app._core.presentation.components.texts.LabelMedium
import com.ceritakita.app._core.presentation.components.texts.LabelSmall
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app.auth.presentation.screen.EmailVerificationScreen
import com.ceritakita.app.auth.presentation.screen.EmailVerificationSuccessScreen
import com.ceritakita.app.auth.presentation.screen.LoginScreen
import com.ceritakita.app.auth.presentation.screen.RegisterScreen
import com.ceritakita.app.counselor.presentation.screen.CounselorDetailScreen
import com.ceritakita.app.counselor.presentation.screen.CounselorListScreen
import com.ceritakita.app.counselor.presentation.screen.PaymentScreen
import com.ceritakita.app.history.presentation.screen.CounselingDetailScreen
import com.ceritakita.app.history.presentation.screen.HistoryScreen
import com.ceritakita.app.homepage.presentation.screen.HomeScreen
import com.ceritakita.app.profile.presentation.screen.ProfileScreen
import com.ceritakita.app.recognition.presentation.screen.RecognitionResultScreen
import com.ceritakita.app.recognition.presentation.screen.TextRecognitionScreen


@Composable
fun Navigation(
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { ElevatedMiddleButtonNav(navController = navController) }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = NavigationScreen.HomeScreen.toString(),
            modifier = Modifier.padding(padding)
        ) {
            composable("homeScreen") {
                HomeScreen(navController)
            }
            composable("profileScreen") {
                ProfileScreen(navController)
            }
            composable("registerScreen") {
                RegisterScreen(navController)
            }
            composable("loginScreen") {
                LoginScreen(navController)
            }
            composable("emailVerificationScreen") {
                EmailVerificationScreen(navController)
            }
            composable("emailVerificationSuccessScreen") {
                EmailVerificationSuccessScreen(navController)
            }
            composable("historyScreen") {
                HistoryScreen(navController)
            }
            composable("counselingDetailScreen") {
                CounselingDetailScreen(navController)
            }
            composable("counselorDetailScreen/{counselorId}") { backStackEntry ->
                val counselorId =
                    backStackEntry.arguments?.getString("counselorId") ?: return@composable
                CounselorDetailScreen(navController, counselorId)
            }
            composable("paymentScreen") {
                PaymentScreen(navController)
            }
            composable("textRecognitionScreen") {
                TextRecognitionScreen(navController)
            }
            composable("counselorListScreen") {
                CounselorListScreen(navController)
            }
            composable("recognitionResultScreen") {
                RecognitionResultScreen(navController)
            }
        }
    }
}

@Composable
fun ElevatedMiddleButtonNav(navController: NavController) {
    val items = listOf(
        NavigationItem(
            "Home",
            ImageVector.vectorResource(id = R.drawable.ic_nav_home),
            ImageVector.vectorResource(id = R.drawable.ic_nav_home_active),
            "homeScreen"
        ),
        NavigationItem(
            "Konseling",
            ImageVector.vectorResource(id = R.drawable.ic_nav_counseling),
            ImageVector.vectorResource(id = R.drawable.ic_nav_counseling_active),
            "counselorListScreen"
        ),
        NavigationItem(
            "",
            ImageVector.vectorResource(id = R.drawable.ic_nav_history),
            ImageVector.vectorResource(id = R.drawable.ic_nav_history),
            NavigationScreen.HistoryScreen.toString()
        ),
        NavigationItem(
            "Riwayat",
            ImageVector.vectorResource(id = R.drawable.ic_nav_history),
            ImageVector.vectorResource(id = R.drawable.ic_nav_history_active),
            "historyScreen"
        ),
        NavigationItem(
            "Akun",
            ImageVector.vectorResource(id = R.drawable.ic_nav_profile),
            ImageVector.vectorResource(id = R.drawable.ic_nav_profile_active),
            "profileScreen"
        )
    )

    Box {
        BottomNavigation(
            backgroundColor = Color.White,
            elevation = 10.dp,
            modifier = Modifier.height(72.dp)
        ) {
            val currentRoute =
                navController.currentBackStackEntryAsState().value?.destination?.route
            Log.d("NavDebug", "Current Route: $currentRoute")
            items.forEach { item ->
                val isSelected = currentRoute == item.route
                Log.d("NavDebug", "Item: ${item.title}, isSelected: $isSelected")
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = if (isSelected) item.activeIcon else item.icon,
                            contentDescription = null,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    },
                    label = {
                        if (isSelected) {
                            LabelSmall(
                                item.title,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        } else {
                            BodySmall(item.title, fontSize = 12.sp)
                        }
                    },
                    selected = isSelected,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    alwaysShowLabel = true,
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Gray
                )
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-20).dp)
                .background(Color.Transparent)
        ) {
            FloatingActionButton(
                onClick = {
                    navController.navigate(NavigationScreen.CounselorListScreen.toString()) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                backgroundColor = BrandColors.brandPrimary600,
                contentColor = Color.White,
                modifier = Modifier.size(72.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Icon(
                        ImageVector.vectorResource(id = R.drawable.ic_nav_scan),
                        contentDescription = null,
                    )
                    LabelSmall("Scan", color = Color.White)
                }

            }
        }
    }
}


data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val activeIcon: ImageVector,
    val route: String
)

@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    var navNum by remember {
        mutableStateOf(0)
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .padding(end = 36.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            if (navNum == 0) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_nav_home_active),
                        contentDescription = "home",
                        tint = TextColors.grey700,
                        modifier = Modifier.size(20.dp)
                    )
                    LabelMedium(text = "Home")
                }
            } else {
                IconButton(onClick = { navNum = 0 }) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_nav_home),
                            contentDescription = "home",
                            tint = TextColors.grey400,
                            modifier = Modifier.size(20.dp)
                        )
                        BodyMedium(text = "Home")
                    }
                }
            }
            if (navNum == 1) {
                IconButton(onClick = { /*TODO*/ }) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_nav_counseling_active),
                            contentDescription = "home",
                            tint = TextColors.grey700,
                            modifier = Modifier.size(20.dp)
                        )
                        LabelMedium(text = "Konseling")
                    }
                }
            } else {
                IconButton(onClick = { navNum = 1 }) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_nav_counseling),
                            contentDescription = "home",
                            tint = TextColors.grey400,
                            modifier = Modifier.size(20.dp)
                        )
                        BodyMedium(text = "Konseling")
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .weight(1f)
                .padding(start = 36.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            if (navNum == 2) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_nav_history),
                        contentDescription = "home",
                        tint = Color.Green,
                        modifier = Modifier.size(25.dp)
                    )
                }
            } else {
                IconButton(onClick = { navNum = 2 }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_nav_history_active),
                        contentDescription = "home",
                        tint = Color.Blue,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            if (navNum == 3) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_nav_profile),
                        contentDescription = "home",
                        tint = Color.Blue,
                        modifier = Modifier.size(25.dp)
                    )
                }
            } else {
                IconButton(onClick = { navNum = 3 }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_nav_profile_active),
                        contentDescription = "home",
                        tint = Color.Blue,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
        }
    }
}
package com.ceritakita.app._core.presentation.ui.navigation

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
import com.ceritakita.app._core.presentation.components.texts.BodySmall
import com.ceritakita.app._core.presentation.components.texts.LabelSmall
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app.auth.presentation.screen.EmailVerificationScreen
import com.ceritakita.app.auth.presentation.screen.EmailVerificationSuccessScreen
import com.ceritakita.app.auth.presentation.screen.LoginScreen
import com.ceritakita.app.auth.presentation.screen.RegisterScreen
import com.ceritakita.app.camera.CameraCaptureScreen
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
fun Navigation() {
    val navController = rememberNavController()
    val currentRoute = currentRoute(navController)
    Scaffold(
        bottomBar = {
            if (currentRoute != "cameraScreen") {
                ElevatedMiddleButtonNav(navController = navController)
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "homeScreen",
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
                val counselorId = backStackEntry.arguments?.getString("counselorId") ?: return@composable
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
            composable("cameraScreen") {
                CameraCaptureScreen(navController)
            }
        }
    }
}

@Composable
fun ElevatedMiddleButtonNav(navController: NavController) {
    val bottomBarState = rememberSaveable { mutableStateOf(true) }
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
            "historyScreen"
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

    val currentRoute = currentRoute(navController = navController)

    LaunchedEffect(currentRoute) {
        bottomBarState.value = currentRoute != "cameraScreen"
    }

    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .navigationBarsPadding()
        ) {
            BottomNavigation(
                backgroundColor = Color.White,
                elevation = 10.dp,
                modifier = Modifier
                    .padding(bottom = 0.dp)
            ) {
                val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
                Log.d("NavDebug", "Current Route: $currentRoute")
                items.forEach { item ->
                    val isSelected = currentRoute == item.route
                    Log.d("NavDebug", "Item: ${item.title}, isSelected: $isSelected")

                    val isDisabled = item.title.isEmpty()

                    BottomNavigationItem(
                        modifier = Modifier.background(Color.White).height(72.dp),
                        icon = {
                            Icon(
                                imageVector = if (isSelected && !isDisabled) item.activeIcon else item.icon,
                                contentDescription = null,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                        },
                        label = {
                            if (isSelected && !isDisabled) {
                                LabelSmall(
                                    item.title,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.padding(top = 0.dp, bottom = 0.dp)
                                )
                            } else {
                                BodySmall(
                                    item.title,
                                    fontSize = 12.sp,
                                    modifier = Modifier.padding(top = 0.dp, bottom = 0.dp)
                                )
                            }
                        },
                        selected = isSelected,
                        onClick = {
                            if (!isDisabled) {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                        alwaysShowLabel = true,
                        selectedContentColor = if (isDisabled) Color.Gray else Color.Black,
                        unselectedContentColor = Color.Gray,
                        enabled = !isDisabled
                    )
                }
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-10).dp)
                    .background(Color.Transparent)
            ) {
                FloatingActionButton(
                    onClick = {
                        navController.navigate("cameraScreen")
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
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}





data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val activeIcon: ImageVector,
    val route: String
)


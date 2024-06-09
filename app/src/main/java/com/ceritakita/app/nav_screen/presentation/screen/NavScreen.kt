package com.ceritakita.app.template_feature.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app._core.presentation.ui.navigation.NavigationScreen
import com.ceritakita.app.history.presentation.screen.CounselingDetailScreen
import com.ceritakita.app.psikolog_flow.presentation.screen.CounselorDetailScreen
import com.ceritakita.app.psikolog_flow.presentation.screen.PaymentScreen
import com.ceritakita.app.recognition.presentation.screen.TextRecognitionScreen

//@Composable
//fun MainScreen() {
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = NavigationScreen.CounselingDetailScreen.toString()) {
//        composable(NavigationScreen.CounselingDetailScreen.toString()) {
//            CounselingDetailScreen(navController)
//        }
//        composable(NavigationScreen.CounselorDetailScreen.toString()) {
//            CounselorDetailScreen(navController)
//        }
//        composable(NavigationScreen.PaymentScreen.toString()) {
//            PaymentScreen(navController)
//        }
//        composable(NavigationScreen.TextRecognitionScreen.toString()) {
//            TextRecognitionScreen(navController)
//        }
//    }
//}
//@Composable
//fun ElevatedMiddleButtonNav(navController: NavController) {
//    val items = listOf(
//        NavigationItem("Home", Icons.Default.Home,
//            NavigationScreen.CounselingDetailScreen.toString()
//        ),
//        NavigationItem("Konseling", Icons.Default.Star,
//            NavigationScreen.CounselorDetailScreen.toString()
//        ),
//        NavigationItem("Lorem", Icons.Default.ShoppingCart,
//            NavigationScreen.PaymentScreen.toString()
//        ),
//        NavigationItem("Riwayat", Icons.Default.Check,
//            NavigationScreen.TextRecognitionScreen.toString()
//        ),
//        NavigationItem("Akun", Icons.Default.AccountCircle,
//            NavigationScreen.CounselingDetailScreen.toString()
//        )  // Example route
//    )
//
//    BottomNavigation(
//        backgroundColor = Color.White,
//        elevation = 5.dp
//    ) {
//        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?
//        items.forEach { item ->
//            BottomNavigationItem(
//                icon = { Icon(item.icon, contentDescription = null) },
//                label = { Text(item.title) },
//                selected = currentRoute == item,
//                onClick = {
//                    navController.navigate(item) {
//                        popUpTo(navController.graph.startDestinationId)
//                        launchSingleTop = true
//                    }
//                },
//                alwaysShowLabel = false, // Set true to always show the label
//                selectedContentColor = Color.Blue,
//                unselectedContentColor = Color.Gray
//            )
//        }
//    }
//}
//data class NavigationItem(val title: String, val icon: ImageVector, val route: String)
//
//
//@Preview(showSystemUi = false, showBackground = true)
//@Composable
//fun PreviewNavScreen() {
//    TemplatePage(navController = rememberNavController())
//}
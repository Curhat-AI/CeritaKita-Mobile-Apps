package com.ceritakita.app.template_feature.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.ui.navigation.NavigationScreen
import com.ceritakita.app.counselor.presentation.screen.CounselorListScreen
import com.ceritakita.app.history.presentation.screen.HistoryScreen
import com.ceritakita.app.homepage.presentation.screen.HomeScreen
import com.ceritakita.app.profile.presentation.screen.ProfileScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { ElevatedMiddleButtonNav(navController = navController) }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = NavigationScreen.HomeScreen.toString(),
            modifier = Modifier.padding(padding)
        ) {
            composable(NavigationScreen.HomeScreen.toString()) {
                HomeScreen(navController)
            }
            composable(NavigationScreen.CounselorListScreen.toString()) {
                CounselorListScreen(navController)
            }
            composable(NavigationScreen.HistoryScreen.toString()) {
                HistoryScreen(navController)
            }
            composable(NavigationScreen.ProfileScreen.toString()) {
                ProfileScreen(navController)
            }
        }
    }
}

@Composable
fun ElevatedMiddleButtonNav(navController: NavController) {
    val items = listOf(
        NavigationItem("Home", ImageVector.vectorResource(id = R.drawable.ic_nav_home), NavigationScreen.HomeScreen.toString()),
        NavigationItem("Konseling",ImageVector.vectorResource(id = R.drawable.ic_nav_counseling), NavigationScreen.CounselorListScreen.toString()),
        NavigationItem("",ImageVector.vectorResource(id = R.drawable.ic_nav_history), NavigationScreen.HistoryScreen.toString()),
        NavigationItem("Riwayat",ImageVector.vectorResource(id = R.drawable.ic_nav_history), NavigationScreen.HistoryScreen.toString()),
        NavigationItem("Akun", ImageVector.vectorResource(id = R.drawable.ic_nav_profile), NavigationScreen.ProfileScreen.toString())
    )

    Box {
        BottomNavigation(
            backgroundColor = Color.White,
            elevation = 5.dp,
            modifier = Modifier.height(70.dp) // Make the BottomNavigation higher to accommodate the middle button
        ) {
            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
            items.forEachIndexed { index, item ->
                BottomNavigationItem(
                    icon = { Icon(item.icon, contentDescription = null) },
                    label = { Text(item.title) },
                    selected = currentRoute == item.route,
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
                .offset(y = (-30).dp) // Adjust the position of the middle button
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
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                modifier = Modifier.size(70.dp) // Size of the middle button
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    Icon(
                        ImageVector.vectorResource(id = R.drawable.ic_nav_scan),
                        contentDescription = null,
                    )
                     Text("Scan") }

                }
            }
        }
    }


data class NavigationItem(val title: String, val icon: ImageVector, val route: String)

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun PreviewNavScreen() {
    MainScreen()
}

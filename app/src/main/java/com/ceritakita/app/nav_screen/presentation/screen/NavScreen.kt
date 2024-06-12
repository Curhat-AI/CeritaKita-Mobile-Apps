package com.ceritakita.app.template_feature.presentation.screen

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
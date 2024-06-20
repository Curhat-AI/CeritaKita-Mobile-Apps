package com.ceritakita.app._core.presentation.ui.navigation

import android.Manifest
import android.content.ContentValues
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.texts.BodySmall
import com.ceritakita.app._core.presentation.components.texts.LabelSmall
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app.auth.presentation.screen.EmailVerificationScreen
import com.ceritakita.app.auth.presentation.screen.EmailVerificationSuccessScreen
import com.ceritakita.app.auth.presentation.screen.LoginScreen
import com.ceritakita.app.auth.presentation.screen.RegisterScreen
import com.ceritakita.app.camera.CameraCaptureScreen
import com.ceritakita.app.camera.createImageFileUri
import com.ceritakita.app.counselor.presentation.screen.CounselorDetailScreen
import com.ceritakita.app.counselor.presentation.screen.CounselorListScreen
import com.ceritakita.app.counselor.presentation.screen.PaymentScreen
import com.ceritakita.app.counselor.presentation.screen.PaymentSuccessScreen
import com.ceritakita.app.history.presentation.screen.CounselingDetailScreen
import com.ceritakita.app.history.presentation.screen.HistoryScreen
import com.ceritakita.app.homepage.presentation.screen.HomeScreen
import com.ceritakita.app.profile.presentation.screen.ProfileScreen
import com.ceritakita.app.recognition.presentation.presentation.viewmodel.PredictViewModel
import com.ceritakita.app.recognition.presentation.screen.RecognitionResultScreen
import com.ceritakita.app.recognition.presentation.screen.TextRecognitionScreen
import com.ceritakita.app.recognition.presentation.screen.self_help.SelfHelpDetailScreen
import com.ceritakita.app.recognition.presentation.screen.self_help.SelfHelpScreen

@Composable
fun AnimatedNavHost() {
    val navController = rememberNavController()
    val currentRoute = currentRoute(navController)
    var predictViewModel: PredictViewModel = hiltViewModel()

    val bottomNavRoutes = listOf(
        "homeScreen",
        "profileScreen",
        "cameraScreen",
        "historyScreen",
        "counselorListScreen"
    )

    Scaffold(
        bottomBar = {
            if (currentRoute in bottomNavRoutes) {
                ElevatedMiddleButtonNav(navController = navController, viewModel = predictViewModel)
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "loginScreen",
            modifier = Modifier.padding(padding),
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeIn(animationSpec = tween(300))
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> -fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> -fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeIn(animationSpec = tween(300))
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                ) + fadeOut(animationSpec = tween(300))
            }
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
            composable("counselingDetailScreen/{sessionId}") { backStackEntry ->
                val sessionId =
                    backStackEntry.arguments?.getString("sessionId") ?: return@composable
                CounselingDetailScreen(navController, sessionId)
            }
            composable("counselorDetailScreen/{counselorId}") { backStackEntry ->
                val counselorId =
                    backStackEntry.arguments?.getString("counselorId") ?: return@composable
                CounselorDetailScreen(navController, counselorId)
            }
            composable(
                "paymentScreen/{sessionId}/{counselorId}/{patientId}/{scheduleId}/{startTime}/{endTime}/{communicationPreference}/{counselingFee}",
                arguments = listOf(
                    navArgument("sessionId") { type = NavType.StringType },
                    navArgument("counselorId") { type = NavType.StringType },
                    navArgument("patientId") { type = NavType.StringType },
                    navArgument("scheduleId") { type = NavType.StringType },
                    navArgument("startTime") { type = NavType.StringType },
                    navArgument("endTime") { type = NavType.StringType },
                    navArgument("communicationPreference") { type = NavType.StringType },
                    navArgument("counselingFee") { type = NavType.IntType }
                )
            ) { backStackEntry ->
                PaymentScreen(
                    navController = navController,
                    sessionId = backStackEntry.arguments?.getString("sessionId") ?: "",
                    counselorId = backStackEntry.arguments?.getString("counselorId") ?: "",
                    patientId = backStackEntry.arguments?.getString("patientId") ?: "",
                    scheduleId = backStackEntry.arguments?.getString("scheduleId") ?: "",
                    startTime = backStackEntry.arguments?.getString("startTime") ?: "",
                    endTime = backStackEntry.arguments?.getString("endTime") ?: "",
                    communicationPreference = backStackEntry.arguments?.getString("communicationPreference")
                        ?: "",
                    counselingFee = backStackEntry.arguments?.getInt("counselingFee") ?: 0
                )
            }
            composable("textRecognitionScreen") {
                TextRecognitionScreen(navController, viewModel = predictViewModel)
            }
            composable("counselorListScreen") {
                CounselorListScreen(navController)
            }
            composable("recognitionResultScreen") {
                RecognitionResultScreen(navController, viewModel = predictViewModel)
            }
            composable("cameraScreen") {
                CameraCaptureScreen(navController, viewModel = predictViewModel)
            }
            composable(
                "selfHelpScreen/{emotion}",
                arguments = listOf(navArgument("emotion") { type = NavType.StringType })
            ) { backStackEntry ->
                val emotion = backStackEntry.arguments?.getString("emotion") ?: ""
                SelfHelpScreen(navController = navController, emotion = emotion)
            }
            composable(
                "selfHelpDetailScreen/{emotion}/{sessionIndex}",
                arguments = listOf(
                    navArgument("emotion") { type = NavType.StringType },
                    navArgument("sessionIndex") { type = NavType.IntType }
                )
            ) { backStackEntry ->
                val emotion = backStackEntry.arguments?.getString("emotion") ?: ""
                val sessionIndex = backStackEntry.arguments?.getInt("sessionIndex") ?: 0
                SelfHelpDetailScreen(navController = navController, emotion = emotion, sessionIndex = sessionIndex)
            }
            composable("paymentSuccessScreen") {
                PaymentSuccessScreen(navController)
            }
        }
    }
}

private val REQUEST_CAMERA_PERMISSION = 100

@Composable
fun ElevatedMiddleButtonNav(
    navController: NavController,
    viewModel: PredictViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    var capturedImageUri by remember { mutableStateOf<Uri?>(null) }

    // RememberLauncher for taking a picture
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
            if (success) {
                capturedImageUri?.let { uri ->
                    Log.d("CameraCaptureScreen", "Image saved successfully: $uri")
                    viewModel.setImageUri(uri.toString())
                    navController.navigate("textRecognitionScreen")
                }
            } else {
                Log.e("CameraCaptureScreen", "Image capture failed")
            }
        }

    // RememberLauncher for requesting camera permission
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            val uri = createImageFileUri(context)
            capturedImageUri = uri
            if (uri != null) {
                launcher.launch(uri)
            }
        } else {
            Toast.makeText(context, "Camera permission denied", Toast.LENGTH_SHORT).show()
        }
    }

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
                val currentRoute =
                    navController.currentBackStackEntryAsState().value?.destination?.route
                Log.d("NavDebug", "Current Route: $currentRoute")
                items.forEach { item ->
                    val isSelected = currentRoute == item.route
                    Log.d("NavDebug", "Item: ${item.title}, isSelected: $isSelected")

                    val isDisabled = item.title.isEmpty()

                    BottomNavigationItem(
                        modifier = Modifier
                            .background(Color.White)
                            .height(72.dp),
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
                        when (PackageManager.PERMISSION_GRANTED) {
                            ContextCompat.checkSelfPermission(
                                context,
                                Manifest.permission.CAMERA
                            ) -> {
                                // Permission is already granted, open camera
                                val uri = createImageFileUri(context)
                                capturedImageUri = uri
                                if (uri != null) {
                                    launcher.launch(uri)
                                }
                            }

                            else -> {
                                // Request camera permission
                                permissionLauncher.launch(Manifest.permission.CAMERA)
                            }
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
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

fun createImageFileUri(context: Context): Uri? {
    val contentResolver = context.contentResolver
    val contentValues = ContentValues().apply {
        put(
            MediaStore.MediaColumns.DISPLAY_NAME,
            "captured_image_${System.currentTimeMillis()}.jpg"
        )
        put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
    }
    return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
}

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val activeIcon: ImageVector,
    val route: String
)
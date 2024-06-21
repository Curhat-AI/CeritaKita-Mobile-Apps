package com.ceritakita.app.profile.presentation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.HeadingMedium
import com.ceritakita.app._core.presentation.components.texts.HeadingSmall
import com.ceritakita.app._core.presentation.components.texts.LabelLarge
import com.ceritakita.app._core.presentation.ui.theme.AppColors
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app.homepage.presentation.viewmodel.UserViewModel
import com.ceritakita.app.profile.presentation.component.SettingSectionComponent
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(navController: NavController) {
    val scope = rememberCoroutineScope()
    var showLogoutDialog by remember { mutableStateOf(false) }
    val viewModelData: UserViewModel = hiltViewModel()
    val userData by viewModelData.userData.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(userData?.photoUrl ?: "https://picsum.photos/600")
                    .crossfade(true)
                    .transformations(CircleCropTransformation())
                    .build(),
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(140.dp)
            )
            userData?.let {
                // Gunakan data user yang dimuat
                Spacer(modifier = Modifier.height(16.dp))
                HeadingMedium(text = "${it.displayName}")
                Spacer(modifier = Modifier.height(4.dp))
                BodyLarge(text = "${it.email}")
            }

        }
        Spacer(modifier = Modifier.height(32.dp))
        Column {
            HeadingSmall(text = "Pengaturan Akun")
            Spacer(modifier = Modifier.height(4.dp))
            SettingSectionComponent(
                text = "Profile",
                painterResource(id = R.drawable.ic_profile_icon),
                onClick = { /* Handle click */ }
            )
            SettingSectionComponent(
                text = "Keamanan Akun",
                painterResource(id = R.drawable.ic_password_bold_icon),
                onClick = { /* Handle click */ }
            )
            SettingSectionComponent(
                text = "Preferensi Pengguna",
                painterResource(id = R.drawable.ic_setting_cube_icon),
                onClick = { /* Handle click */ }
            )
        }
        Spacer(Modifier.weight(1f))
        OutlinedButton(
            onClick = {
                scope.launch {
                    showLogoutDialog = true
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            shape = RoundedCornerShape(100),
            border = BorderStroke(1.dp, AppColors.errorColor),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = BrandColors.brandPrimary500
            )
        ) {
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_logout_icon),
                    contentDescription = "Logout",
                    modifier = Modifier.size(24.dp),
                    tint = AppColors.errorColor
                )
                Spacer(modifier = Modifier.width(8.dp))
                LabelLarge("Logout", color = AppColors.errorColor)
            }
        }
        if (showLogoutDialog) {
            AlertDialog(
                onDismissRequest = { showLogoutDialog = false },
                title = {
                    BodyLarge(
                        text = "Are you sure you want to logout?",
                        fontWeight = FontWeight.SemiBold
                    )
                },
                text = { BodyLarge(text = "Lorem ipsum") },
                confirmButton = {
                    CustomButton(text = "Confirm", onClick = {
                        showLogoutDialog = false
                        scope.launch {
//                                viewModel.logout()
                            navController.navigate("loginScreen") {
                                popUpTo(navController.graph.startDestinationId) {
                                    inclusive = true
                                }
                            }
                        }
                    })
                }
            )
        }
    }
}
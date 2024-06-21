package com.ceritakita.app.homepage.presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.components.texts.LabelMedium
import com.ceritakita.app._core.presentation.components.texts.TitleLarge
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors

@Composable
fun TestActionCard(
    onClick: () -> Unit, // Tambahkan parameter untuk menangani klik
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .border(1.dp, TextColors.grey200, RoundedCornerShape(8.dp))
            .shadow(
                elevation = 10.dp,
                spotColor = Color(0xFF000000).copy(alpha = 0.1f),
                ambientColor = Color(0xFF000000).copy(alpha = 0.1f),
                clip = true
            ),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = BrandColors.brandPrimary50,
            disabledContainerColor = Color.Red
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            TitleLarge(text = "Tetap Lacak Kesehatan Mentalmu")
            Spacer(modifier = Modifier.height(4.dp))
            BodyLarge(text = "Dapatkan ringkasan tentang kesehatan mentalmu melalui Tes Kesehatan Mental")
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_verified_icon),
                        contentDescription = "Calendar Icon",
                        modifier = Modifier.size(20.dp),
                        tint = BrandColors.brandPrimary600
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    BodyMedium(
                        text = "Terverifikasi Lorem",
                        color = BrandColors.brandPrimary600,
                        fontWeight = FontWeight.Medium
                    )
                }
                Button(
                    onClick = onClick, // Panggil lambda onClick saat tombol diklik
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = BrandColors.brandPrimary600
                    ),
                    shape = CircleShape,
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
                ) {
                    LabelMedium(text = "Mulai Tes", color = Color.White, modifier = Modifier.clickable {
                        onClick()
                    })
                }
            }
        }
    }
}
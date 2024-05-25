package com.ceritakita.app.history.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.components.texts.TitleMedium
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors

@Composable
fun RingkasanPembayaranCard(
    counselingPrice: String = "Rp. 100.000",
    counselingDiscount: String = "Rp. 0",
    counselingPPN: String = "Rp. 0",
    counselingTotal: String = "Rp. 150.000",
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                border = BorderStroke(1.dp, color = TextColors.grey200),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BodyLarge(text = "Biaya Konseling")
                Spacer(modifier = Modifier.width(8.dp))
                TitleMedium(
                    text = counselingPrice,
                    color = TextColors.grey700,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Divider(thickness = 1.dp, color = TextColors.grey200)
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BodyLarge(text = "Diskon")
                Spacer(modifier = Modifier.width(8.dp))
                TitleMedium(
                    text = counselingDiscount,
                    color = TextColors.grey700,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Divider(thickness = 1.dp, color = TextColors.grey200)
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BodyLarge(text = "PPN")
                Spacer(modifier = Modifier.width(8.dp))
                TitleMedium(
                    text = counselingPPN,
                    color = TextColors.grey700,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            DottedLine(
                color = TextColors.grey200,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TitleMedium(
                    text = "Total Pembayaran",
                    color = TextColors.grey700,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.width(8.dp))
                TitleMedium(
                    text = counselingTotal,
                    fontWeight = FontWeight.Bold,
                    color = BrandColors.brandPrimary600
                )
            }
        }
    }
}

@Preview
@Composable
fun RingkasanPembayaranCardPreview() {
    RingkasanPembayaranCard()
}
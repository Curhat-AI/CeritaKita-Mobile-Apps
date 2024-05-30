package com.ceritakita.app.psikolog_flow.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.texts.LabelLarge
import com.ceritakita.app._core.presentation.components.texts.TitleLarge
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors

data class PaymentOption(
    val id: String,
    val name: String,
    val icon: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentMethodBottomSheet(
    onSubmit: (String, Int) -> Unit,
    onDismiss: () -> Unit,
    ewalletList: List<PaymentOption>,
    bankList: List<PaymentOption>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    var showBottomSheet by remember { mutableStateOf(true) }

    if (showBottomSheet) {
        ModalBottomSheet(
            containerColor = Color.White,
            onDismissRequest = {
                showBottomSheet = false
                onDismiss()
            }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .imePadding()
            ) {
                TitleLarge(text = "E-Wallet")
                Spacer(modifier = Modifier.height(4.dp))
                Column {
                    ewalletList.forEach { option ->
                        PaymentOptionRow(option, selectedOption, onOptionSelected)
                        Divider(thickness = 1.dp, color = TextColors.grey200)
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                TitleLarge(text = "Bank")
                Spacer(modifier = Modifier.height(4.dp))
                Column {
                    bankList.forEach { option ->
                        PaymentOptionRow(option, selectedOption, onOptionSelected)
                        Divider(thickness = 1.dp, color = TextColors.grey200)
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                CustomButton(text = "Pilih Payment", onClick = { onSubmit(selectedOption, 100) })
            }
        }
    }
}

@Composable
fun PaymentOptionRow(
    option: PaymentOption,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .selectable(
                selected = (option.id == selectedOption),
                onClick = { onOptionSelected(option.id) }
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = option.icon),
            contentDescription = option.name,
            modifier = Modifier
                .height(36.dp)
                .width(42.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        LabelLarge(text = option.name)
        Spacer(Modifier.weight(1f))
        RadioButton(
            modifier = Modifier.padding(vertical = 16.dp),
            selected = option.id == selectedOption,
            colors = RadioButtonDefaults.colors(
                selectedColor = BrandColors.brandPrimary600,
                unselectedColor = TextColors.grey400
            ),
            onClick = { onOptionSelected(option.id) }
        )
    }
}
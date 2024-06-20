package com.ceritakita.app.counselor.presentation.component.multistep_form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.TitleLarge
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app.counselor.presentation.component.AssessmentButtonComponent
import com.ceritakita.app.counselor.presentation.component.ButtonType
import com.ceritakita.app.counselor.presentation.component.CheckboxComponent
import com.ceritakita.app.counselor.presentation.viewmodel.AssessmentViewModel


@Composable
fun StepOne(viewModel: AssessmentViewModel, onNext: () -> Unit) {
// Directly use the list from the ViewModel without collectAsState
    val mentoring = viewModel.servicePreferences.contains("Mentoring")
    val counseling = viewModel.servicePreferences.contains("Counseling")

    Column(modifier = Modifier.padding(16.dp)) {
        TitleLarge("Apa jenis layanan yang kamu butuhkan?")
        Spacer(modifier = Modifier.height(4.dp))
        BodyLarge(text = "Pilih salah satu atau lebih")
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckboxComponent(
                checked = mentoring,
                onCheckedChange = { isChecked ->
                    viewModel.addOrRemovePreference(
                        "Mentoring",
                        isChecked,
                        viewModel.servicePreferences
                    )
                }
            )
            BodyLarge(
                "Mentoring",
                modifier = Modifier.padding(start = 8.dp),
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = TextColors.grey800
            )
        }
        Row(
            modifier = Modifier.padding(bottom = 40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckboxComponent(
                checked = counseling,
                onCheckedChange = { isChecked ->
                    viewModel.addOrRemovePreference(
                        "Counseling",
                        isChecked,
                        viewModel.servicePreferences
                    )
                }
            )
            BodyLarge(
                "Konseling", modifier = Modifier.padding(start = 8.dp),
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = TextColors.grey800
            )
        }
        AssessmentButtonComponent(
            text = "Selanjutnya",
            buttonType = ButtonType.Primary,
            onClick = onNext,
            enabled = mentoring || counseling
        )
    }
}
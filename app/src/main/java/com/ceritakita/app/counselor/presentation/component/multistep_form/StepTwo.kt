package com.ceritakita.app.counselor.presentation.component.multistep_form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
fun StepTwo(viewModel: AssessmentViewModel, onNext: () -> Unit, onBack: () -> Unit) {
    val social = viewModel.topicPreferences.contains("Social")
    val relationship = viewModel.topicPreferences.contains("Relationship")
    val romantic = viewModel.topicPreferences.contains("Romantic")
    val economy = viewModel.topicPreferences.contains("Economy")
    val work = viewModel.topicPreferences.contains("Work")
    val school = viewModel.topicPreferences.contains("School")

    Column(modifier = Modifier.padding(16.dp)) {
        TitleLarge("Apa topik yang mau kamu ceritakan?")
        Spacer(modifier = Modifier.height(4.dp))
        BodyLarge(text = "Pilih salah satu atau lebih")
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckboxComponent(
                checked = social,
                onCheckedChange = { isActive -> viewModel.addOrRemovePreference("Social", isActive, viewModel.topicPreferences) }
            )
            BodyLarge(
                "Social",
                modifier = Modifier.padding(start = 8.dp),
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = TextColors.grey800
            )
        }

        Row(
            modifier = Modifier.padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckboxComponent(
                checked = relationship,
                onCheckedChange = { isActive -> viewModel.addOrRemovePreference("Relationship", isActive, viewModel.topicPreferences) }
            )
            BodyLarge(
                "Relationship", modifier = Modifier.padding(start = 8.dp),
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = TextColors.grey800
            )
        }
        Row(
            modifier = Modifier.padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckboxComponent(
                checked = romantic,
                onCheckedChange = { isActive -> viewModel.addOrRemovePreference("Romantic", isActive, viewModel.topicPreferences) }
            )
            BodyLarge(
                "Romantic",
                modifier = Modifier.padding(start = 8.dp),
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = TextColors.grey800
            )
        }

        Row(
            modifier = Modifier.padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckboxComponent(
                checked = economy,
                onCheckedChange = { isActive -> viewModel.addOrRemovePreference("Economy", isActive, viewModel.topicPreferences) }
            )
            BodyLarge(
                "Economy",
                modifier = Modifier.padding(start = 8.dp),
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = TextColors.grey800
            )
        }

        Row(
            modifier = Modifier.padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckboxComponent(
                checked = work,
                onCheckedChange = { isActive -> viewModel.addOrRemovePreference("Work", isActive, viewModel.topicPreferences) }
            )
            BodyLarge(
                "Work",
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
                checked = school,
                onCheckedChange = { isActive -> viewModel.addOrRemovePreference("School", isActive, viewModel.topicPreferences) }
            )
            BodyLarge(
                "School",
                modifier = Modifier.padding(start = 8.dp),
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = TextColors.grey800
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AssessmentButtonComponent(
                text = "Kembali",
                onClick = onBack,
                buttonType = ButtonType.Secondary,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            AssessmentButtonComponent(
                text = "Selanjutnya",
                onClick = onNext,
                buttonType = ButtonType.Primary,
                enabled = social || relationship || romantic || economy || work || school,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
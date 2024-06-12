package com.ceritakita.app.counselor.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import com.ceritakita.app.R
import com.google.android.material.datepicker.MaterialDatePicker
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

@Composable
fun DateSelector(onDateSelected: (LocalDate) -> Unit) {
    var showDatePicker by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { showDatePicker = true },
        shape = RoundedCornerShape(8.dp),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calendar_bold_icon),
                    contentDescription = "Select Date",
                    modifier = Modifier.size(24.dp),
                    tint = Color(0xFF6200EE)
                )
                Text(text = "Mei", color = Color(0xFF6200EE))
            }
        }
    }

    if (showDatePicker) {
        ShowDatePicker(onDateSelected = {
            onDateSelected(it)
            showDatePicker = false // Reset the state after selection
        })
    }
}

@Composable
fun ShowDatePicker(onDateSelected: (LocalDate) -> Unit) {
    val context = LocalContext.current
    val fragmentManager = (context as? FragmentActivity)?.supportFragmentManager
    val datePicker = MaterialDatePicker.Builder.datePicker().build()

    datePicker.addOnPositiveButtonClickListener {
        onDateSelected(Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDate())
    }

    LaunchedEffect(Unit) {
        fragmentManager?.let {
            datePicker.show(it, "DATE_PICKER_TAG")
        }
    }
}

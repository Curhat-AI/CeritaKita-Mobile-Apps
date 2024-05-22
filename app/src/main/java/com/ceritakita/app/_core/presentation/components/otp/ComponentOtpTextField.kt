package com.ceritakita.app._core.presentation.components.otp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

enum class OtpType {
    Number,
    Mix
}

@Composable
fun CommonOtpTextField(
    otp: MutableState<String>,
    focusRequester: FocusRequester,
    onNext: () -> Unit,
    onPrevious: () -> Unit,
    otpType: OtpType
) {
    val max = 1
    val keyboardType = when (otpType) {
        OtpType.Number -> KeyboardType.Number
        OtpType.Mix -> KeyboardType.Text
    }

    OutlinedTextField(
        value = otp.value,
        singleLine = true,
        onValueChange = {
            if (it.length <= max) {
                if (it.isEmpty() && otp.value.isNotEmpty()) {
                    onPrevious()
                }
                otp.value = it
                if (it.length == max) {
                    onNext()
                }
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(onNext = { onNext() }),
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .width(80.dp)
            .height(50.dp)
            .focusRequester(focusRequester),
        maxLines = 1,
        textStyle = TextStyle(
            textAlign = TextAlign.Center
        )
    )
}

@Composable
fun OtpInputRow(otpType: OtpType) {
    val otpOne = remember { mutableStateOf("") }
    val otpTwo = remember { mutableStateOf("") }
    val otpThree = remember { mutableStateOf("") }
    val otpFour = remember { mutableStateOf("") }

    val (requesterOne, requesterTwo, requesterThree, requesterFour) = remember {
        listOf(FocusRequester(), FocusRequester(), FocusRequester(), FocusRequester())
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, start = 15.dp, end = 15.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        CommonOtpTextField(
            otp = otpOne,
            focusRequester = requesterOne,
            onNext = { requesterTwo.requestFocus() },
            onPrevious = {},
            otpType = otpType
        )
        CommonOtpTextField(
            otp = otpTwo,
            focusRequester = requesterTwo,
            onNext = { requesterThree.requestFocus() },
            onPrevious = { requesterOne.requestFocus() },
            otpType = otpType
        )
        CommonOtpTextField(
            otp = otpThree,
            focusRequester = requesterThree,
            onNext = { requesterFour.requestFocus() },
            onPrevious = { requesterTwo.requestFocus() },
            otpType = otpType
        )
        CommonOtpTextField(
            otp = otpFour,
            focusRequester = requesterFour,
            onNext = { /* Final action */ },
            onPrevious = { requesterThree.requestFocus() },
            otpType = otpType
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOtpInputRow() {
    OtpInputRow(OtpType.Number)
}

package com.ceritakita.app._core.presentation.components.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ceritakita.app._core.presentation.components.texts.LabelLarge


@Composable
fun TextFieldOutline(){
    var email by remember { mutableStateOf("kahfismith@gmail.com") }

    Column(        horizontalAlignment = Alignment.Start,
    ) {
        LabelLarge("Email")
        Spacer(modifier = Modifier.heightIn(5.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Email,
                    contentDescription = "Email Icon"
                )
            },
            modifier = Modifier
                .fillMaxWidth()

        )
    }
}

@Composable
fun TextFieldOutlinePassword(){
    var password by remember { mutableStateOf("kahfismith@gmail.com") }

    Column(        horizontalAlignment = Alignment.Start,
    ) {
        LabelLarge("Password")
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Lock,
                    contentDescription = "Password Icon"
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
    }
}
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun previewTextfield(){
    TextFieldOutline()
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun previewTextfieldPassword(){
    TextFieldOutlinePassword()
}
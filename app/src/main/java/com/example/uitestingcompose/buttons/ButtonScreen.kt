package com.example.uitestingcompose.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.example.uitestingcompose.constants.ComposeTestTags

@Composable
fun ButtonScreen() {
    var textButton by rememberSaveable { mutableStateOf("Text Button") }
    val checked = rememberSaveable { mutableStateOf(false) }
    val isOn = rememberSaveable { mutableStateOf(false) }
    val showButton = rememberSaveable { mutableStateOf(true) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            textButton = "Button 1"
        }, modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .semantics {
                contentDescription = "btnButton1"
            }) {
            Text(text = textButton)
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Checkbox:")
            Checkbox(checked = checked.value, onCheckedChange = { checked.value = it }, modifier = Modifier.testTag(
                ComposeTestTags.CHECKBOX_TEST_TAG))
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Switch:")
            Switch(checked = isOn.value, onCheckedChange = { isOn.value = it }, modifier = Modifier.testTag(
                ComposeTestTags.SWITCH_TEST_TAG))
        }
        if(showButton.value){
            Button(onClick = {
                showButton.value = false
            }, modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .semantics {
                    contentDescription = "btnButton2"
                }) {
                Text(text = "Text Button2")
            }
        }

    }
}
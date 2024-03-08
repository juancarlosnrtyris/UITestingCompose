package com.example.uitestingcompose.texts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.sp
import com.example.uitestingcompose.constants.ComposeTestTags

@Composable
fun TextScreen() {
    var name by rememberSaveable { mutableStateOf("") }
    var showText by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "TEST TEXTOS COMPOSE", fontSize = 24.sp)
        Text(text = name, modifier = Modifier.testTag(ComposeTestTags.TEXT_TEST_TAG))
        TextField(
            value = name,
            onValueChange = { name = it },
            singleLine = true,
            maxLines = 1,
            modifier = Modifier.testTag(ComposeTestTags.INPUT_TEST_TAG),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {showText = !showText}
            )
        )
        if(showText){
            Text(text = "Prueba Component", modifier = Modifier.testTag(ComposeTestTags.SECOND_TEXT_TEST_TAG))
        }
    }
}
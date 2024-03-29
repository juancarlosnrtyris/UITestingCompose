package com.example.uitestingcompose.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.example.uitestingcompose.constants.ComposeTestTags
import com.example.uitestingcompose.navigation.NavigationItem

@Composable
fun HomeScreen(navigate: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            navigate(NavigationItem.Buttons.route)
        }, modifier = Modifier.align(Alignment.CenterHorizontally).testTag(ComposeTestTags.NAVIGATE_BUTTONS_TEST_TAG)) {
            Text(text = "Navigate To Buttons")
        }
        Button(onClick = {
            navigate(NavigationItem.Texts.route)
        }, modifier = Modifier.align(Alignment.CenterHorizontally).testTag(ComposeTestTags.NAVIGATE_TEXTS_TEST_TAG)) {
            Text(text = "Navigate To Texts")
        }
        Button(onClick = {
            navigate(NavigationItem.Lists.route)
        }, modifier = Modifier.align(Alignment.CenterHorizontally).testTag(ComposeTestTags.NAVIGATE_LISTS_TEST_TAG)) {
            Text(text = "Navigate To Lists")
        }
        Button(onClick = {
            navigate(NavigationItem.Tasks.route)
        }, modifier = Modifier.align(Alignment.CenterHorizontally).testTag(ComposeTestTags.NAVIGATE_TASKS_TEST_TAG)) {
            Text(text = "Navigate To Tasks")
        }
    }
}
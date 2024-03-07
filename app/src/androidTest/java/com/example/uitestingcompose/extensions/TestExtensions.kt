package com.example.uitestingcompose.extensions

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.atiurin.ultron.core.compose.createUltronComposeRule
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import org.junit.rules.TestRule

fun <R : TestRule, A : ComponentActivity> AndroidComposeTestRule<R, A>.setContentOnActivity(
    content: @Composable () -> Unit
) {
    this.activity.runOnUiThread {
        this.activity.setContent {
            content()
        }
    }
}
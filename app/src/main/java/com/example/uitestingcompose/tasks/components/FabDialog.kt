package com.example.uitestingcompose.tasks.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.example.uitestingcompose.tasks.presentation.UIEvent

@Composable
fun FabDialog(modifier: Modifier,  uiEvent:(UIEvent) -> Unit) {
    FloatingActionButton(onClick = {
        uiEvent(UIEvent.ShowDialog)
    }, modifier = modifier.semantics {
        contentDescription = "fabDialog"
    }) {
        Icon(Icons.Filled.Add, contentDescription = "")
    }
}

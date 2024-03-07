package com.example.uitestingcompose.tasks.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.uitestingcompose.tasks.components.AddTasksDialog
import com.example.uitestingcompose.tasks.components.FabDialog
import com.example.uitestingcompose.tasks.components.TasksList

@Composable
fun TasksScreen(tasksState: TaskState, uiEvent:(UIEvent) -> Unit) {

    Box(modifier = Modifier.fillMaxSize()) {
        AddTasksDialog(
            tasksState.showDialog,
            onDismiss = { uiEvent(UIEvent.DismissDialog) },
            onTaskAdded = { uiEvent(UIEvent.TaskCreated(it)) })
        FabDialog(Modifier.align(Alignment.BottomEnd)) { uiEvent(it) }
        TasksList(tasksState.tasks){uiEvent(it)}
    }
}




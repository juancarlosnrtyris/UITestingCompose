package com.example.uitestingcompose.tasks.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.example.uitestingcompose.constants.ComposeTestTags.TASK_LIST_TEST_TAG
import com.example.uitestingcompose.tasks.presentation.UIEvent
import com.example.uitestingcompose.tasks.model.TaskModel


@Composable
fun TasksList(tasks:List<TaskModel>, uiEvent:(UIEvent) -> Unit) {
    LazyColumn(modifier = Modifier.testTag(TASK_LIST_TEST_TAG)) {
        items(tasks, key = { it.id }) { task ->
            ItemTask(task){uiEvent(it)}
        }
    }
}

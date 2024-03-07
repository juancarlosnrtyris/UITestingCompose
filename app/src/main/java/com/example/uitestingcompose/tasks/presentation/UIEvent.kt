package com.example.uitestingcompose.tasks.presentation

import com.example.uitestingcompose.tasks.model.TaskModel

interface UIEvent {
    data object DismissDialog: UIEvent
    data class TaskCreated(val task:String): UIEvent
    data object ShowDialog: UIEvent
    data class RemoveTask(val task:TaskModel): UIEvent
    data class TaskSelected(val task:TaskModel): UIEvent
}
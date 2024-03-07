package com.example.uitestingcompose.tasks.presentation

import com.example.uitestingcompose.tasks.model.TaskModel

data class TaskState(
    val tasks:MutableList<TaskModel> = mutableListOf(),
    val showDialog:Boolean = false,
    val isLoading:Boolean = false
)

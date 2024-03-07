package com.example.uitestingcompose.tasks.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.uitestingcompose.tasks.model.TaskModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(TaskState())
        private set

    fun sendUIEvent(uiEvent: UIEvent) {
        when (uiEvent) {
            UIEvent.DismissDialog -> onDialogClose()
            is UIEvent.TaskCreated -> onTasksCreated(uiEvent.task)
            UIEvent.ShowDialog -> onShowDialogClick()
            is UIEvent.RemoveTask -> onItemRemove(uiEvent.task)
            is UIEvent.TaskSelected -> onCheckBoxSelected(uiEvent.task)
        }

    }

    private fun onDialogClose() {
        state = state.copy(showDialog = false)
    }

    fun clearAllTasks() {
        state = state.copy(showDialog = false,tasks = state.tasks.toMutableList().apply{clear()})
    }

    private fun onTasksCreated(task: String) {
        state = state.copy(showDialog = false,tasks = state.tasks.toMutableList().apply { add(TaskModel(task = task))})
    }

    private fun onShowDialogClick() {
        state = state.copy(showDialog = true)
    }

    private fun onCheckBoxSelected(taskModel: TaskModel) {
        val updatedTasks = state.tasks.map { task ->
            if (task == taskModel) {
                task.copy(selected = !task.selected)
            } else {
                task
            }
        }
        state = state.copy(tasks = updatedTasks.toMutableList())
    }

    private fun onItemRemove(taskModel: TaskModel) {
        val task = state.tasks.find { it.id == taskModel.id }
        state = state.copy(tasks = state.tasks.toMutableList().apply {remove(task)})
    }

}
package com.example.uitestingcompose.tasks

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.uitestingcompose.tasks.components.AddTasksDialog
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TasksDialogTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenDialogGetATrue_thenShowDialog(){
        composeTestRule.setContent {
            AddTasksDialog(show = true, onDismiss = {}, onTaskAdded = {})
        }

        composeTestRule.onNodeWithTag("inputMailLogin")

        composeTestRule.onNodeWithText("Esto es una prueba", ignoreCase = true)


        composeTestRule.onNodeWithTag("dialog").assertIsDisplayed()
    }

    @Test
    fun whenDialogGetAFalse_thenDoNotShowDialog(){
        composeTestRule.setContent {
            AddTasksDialog(show = false, onDismiss = {}, onTaskAdded = {})
        }

        //Al tener un condicional no se llega a crear el dialogo con el testag
        // y no se puede comprobar si esta en la pantalla
        composeTestRule.onNodeWithTag("dialog").assertDoesNotExist()
    }

    @Test
    fun whenDialogStartThenVerifyContentIsEmpty() {
        composeTestRule.setContent {
            AddTasksDialog(show = true, onDismiss = {}, onTaskAdded = {})
        }

        composeTestRule.onNodeWithTag("inputDialog")
            .assertTextEquals("")
    }

    //Android
    @Test
    fun whenTaskIsAddedThenVerifyTextContainTask() {
        composeTestRule.setContent {
            AddTasksDialog(show = true, onDismiss = {}, onTaskAdded = {})
        }

        composeTestRule.onNodeWithTag("inputDialog").performTextInput("Task")

        composeTestRule.onNodeWithTag("inputDialog")
            .assertTextContains("Task")
    }

    @Test
    fun whenDialogStartTextAddTaskShouldContainText() {
        composeTestRule.setContent {
            AddTasksDialog(show = true, onDismiss = {}, onTaskAdded = {})
        }
        composeTestRule.onNodeWithTag("textAddTask")
            .assertTextContains("Añade tu tarea")
    }

    @Test
    fun whenDialogStartTextAddTaskShouldDisplayed() {
        composeTestRule.setContent {
            AddTasksDialog(show = true, onDismiss = {}, onTaskAdded = {})
        }
        composeTestRule.onNodeWithTag("textAddTask")
            .assertIsDisplayed()
    }


    @Test
    fun whenDialogStartBtnAddTaskShouldContainText() {
        composeTestRule.setContent {
            AddTasksDialog(show = true, onDismiss = {}, onTaskAdded = {})
        }

        composeTestRule.onNodeWithTag("btnAddTask").assertTextContains("Añadir tarea")

    }

    @Test
    fun whenComponentStartThenVerifyContentIsEmpty() {
        composeTestRule.setContent {
            AddTasksDialog(show = true, onDismiss = {}, onTaskAdded = {})
        }
        composeTestRule.onNodeWithTag("inputDialog").assertTextContains("")
    }

}
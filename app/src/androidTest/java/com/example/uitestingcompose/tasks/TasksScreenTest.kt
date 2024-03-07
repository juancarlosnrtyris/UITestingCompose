package com.example.uitestingcompose.tasks

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.longClick
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onLast
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performScrollToIndex
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.performTouchInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.uitestingcompose.tasks.constants.Constants
import com.example.uitestingcompose.tasks.model.TaskModel
import com.example.uitestingcompose.tasks.presentation.TaskState
import com.example.uitestingcompose.tasks.presentation.TasksScreen
import com.example.uitestingcompose.ui.theme.UITestingComposeTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TasksScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenClickInFabDialogShouldIsDisplayedAddTaskDialog(){
        composeTestRule.setContent {
            UITestingComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TasksScreen(TaskState(showDialog = true, tasks = mutableListOf(TaskModel(id = 1,task = "task1")))){}
                }
            }
        }

        // Comprueba que el diálogo no está visible inicialmente

        composeTestRule.onNodeWithContentDescription("fabDialog").performTouchInput {  }

        composeTestRule.onAllNodesWithTag("fabDialog")[3]

        composeTestRule.onNodeWithTag("inputDialog").performTextReplacement("Task4")
        composeTestRule.onNodeWithTag("btnAddTask").performClick()

        composeTestRule.onNodeWithTag(Constants.TASK_LIST_TEST_TAG)
            .onChildren()
            .assertCountEquals(1)
    }

    @Test
    fun whenClickInFabDialogShouldIsDisplayedAddTdaskDialog(){
        composeTestRule.setContent {
            UITestingComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TasksScreen(TaskState(showDialog = false,tasks = mutableListOf(TaskModel(id = 1,task = "task1")))){}
                }
            }
        }

        // Comprueba que el diálogo no está visible inicialmente

        composeTestRule.onNodeWithText("task1").assertIsDisplayed()
    }
}
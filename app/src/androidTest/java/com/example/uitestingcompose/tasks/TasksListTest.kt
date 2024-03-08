package com.example.uitestingcompose.tasks

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performScrollToIndex
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.uitestingcompose.constants.ComposeTestTags.TASK_LIST_TEST_TAG
import com.example.uitestingcompose.tasks.components.TasksList
import com.example.uitestingcompose.tasks.model.TaskModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TasksListTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenTaskListIsEmptyShouldCountEquals0() {
        composeTestRule.setContent {
            TasksList(listOf(), {})
        }
        composeTestRule.onNodeWithTag(TASK_LIST_TEST_TAG)
            .onChildren()
            .assertCountEquals(0)
    }


    @Test
    fun whenTaskListIsEmptyShouldCountEquals2() {
        composeTestRule.setContent {
            TasksList(
                listOf(
                    TaskModel(id = 1, task = "Task1"),
                    TaskModel(id = 2, task = "Task2")
                )
            ) {}
        }

        composeTestRule.onNodeWithTag(TASK_LIST_TEST_TAG)
            .onChildren()
            .assertCountEquals(2)
    }

    @Test
    fun testFirstAndLastTaskDescription() {
        composeTestRule.setContent {
            TasksList(
                listOf(
                    TaskModel(id = 1, task = "Task1"),
                    TaskModel(id = 2, task = "Task2")
                )
            ) {}
        }
        composeTestRule.onNodeWithText("Task1").assertExists()

        composeTestRule.onNodeWithText("Task2").assertIsDisplayed()
    }

    @Test
    fun testWhenNotScrollToIndex12IsDisplayed() {
        composeTestRule.setContent {
            TasksList(
                listTasks
            ) {}
        }
        listTasks.forEach { item ->
            if(item.id >= 12){
                composeTestRule.onNodeWithText(item.task).assertDoesNotExist()
            }
        }
    }


    @Test
    fun testWhenNotScrollToInddex12IsDisplayed() {
        composeTestRule.setContent {
            TasksList(
                listTasks
            ) {}
        }
        listTasks.forEach { item ->
            if(item.id < 12){
                composeTestRule.onNodeWithText(item.task).assertIsDisplayed()
            }
        }
    }

    @Test
    fun testWhenScrollToIndex12IsDisplayed() {
        composeTestRule.setContent {
            TasksList(
                listTasks
            ) {}
        }

        composeTestRule.onNodeWithTag(TASK_LIST_TEST_TAG).performScrollToIndex(12)

        composeTestRule.onNodeWithText("Task12").assertIsDisplayed()
    }

    @Test
    fun testWhenScrollToIndexLastItemIsDisplayed() {
        composeTestRule.setContent {
            TasksList(
                listTasks
            ) {}
        }
        composeTestRule.onNodeWithTag(TASK_LIST_TEST_TAG).performScrollToIndex(listTasks.size-1)
        composeTestRule.onNodeWithText(listTasks.last().task).assertIsDisplayed()
    }

    private val listTasks =  listOf(
        TaskModel(id = 1, task = "Task1"),
        TaskModel(id = 2, task = "Task2"),
        TaskModel(id = 3, task = "Task3"),
        TaskModel(id = 4, task = "Task4"),
        TaskModel(id = 5, task = "Task5"),
        TaskModel(id = 6, task = "Task6"),
        TaskModel(id = 7, task = "Task7"),
        TaskModel(id = 8, task = "Task8"),
        TaskModel(id = 9, task = "Task9"),
        TaskModel(id = 10, task = "Task10"),
        TaskModel(id = 11, task = "Task11"),
        TaskModel(id = 12, task = "Task12"),
        TaskModel(id = 13, task = "Task13"),
        TaskModel(id = 14, task = "Task14"),
        TaskModel(id = 15, task = "Task15")
    )
}


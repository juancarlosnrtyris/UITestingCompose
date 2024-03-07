package com.example.uitestingcompose

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.atiurin.ultron.allure.config.UltronAllureConfig
import com.atiurin.ultron.allure.listeners.DetailedOperationAllureListener
import com.atiurin.ultron.allure.listeners.ScreenshotAttachListener
import com.atiurin.ultron.allure.listeners.WindowHierarchyAttachListener
import com.atiurin.ultron.core.compose.config.UltronComposeConfig
import com.atiurin.ultron.core.compose.createUltronComposeRule
import com.atiurin.ultron.core.compose.list.composeList
import com.atiurin.ultron.core.config.UltronConfig
import com.atiurin.ultron.extensions.assertIsDisplayed
import com.atiurin.ultron.extensions.assertIsNotDisplayed
import com.example.uitestingcompose.tasks.components.TasksList
import com.example.uitestingcompose.tasks.constants.Constants
import com.example.uitestingcompose.tasks.model.TaskModel
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UltronExamples {

    @get:Rule
    val composeTestRule = createUltronComposeRule<MainActivity>()

    @Before
    fun  setConfig () {
        UltronConfig.applyRecommended()
        UltronAllureConfig.applyRecommended()
        UltronComposeConfig.applyRecommended()
    }
    //Ultron
    @Test
    fun testWhenScrollToIndex12IsDisplayedUltron() {
        hasTestTag(Constants.TASK_LIST_TEST_TAG).assertIsNotDisplayed()
        /*composeList(hasTestTag(Constants.TASK_LIST_TEST_TAG))
            .item(hasText("Task12"))
            .assertIsDisplayed()*/
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
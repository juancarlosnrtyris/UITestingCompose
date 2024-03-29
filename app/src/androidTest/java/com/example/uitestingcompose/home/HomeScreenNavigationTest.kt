package com.example.uitestingcompose.home

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.uitestingcompose.constants.ComposeTestTags
import com.example.uitestingcompose.navigation.AppNavHost
import com.example.uitestingcompose.navigation.NavigationItem
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeScreenNavigationTest {

    @get: Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    fun setupAppNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            AppNavHost(navController = navController)
        }
    }

    @Test
    fun composeTestingNavHost_verifyStartDestination() {
        navController.assertCurrentRouteName(NavigationItem.Home.route)
    }

    @Test
    fun appNavHost_clickBtnTasks_navigatesToTasksScreen() {
        composeTestRule.onNodeWithTag(ComposeTestTags.NAVIGATE_TASKS_TEST_TAG).performClick()
        navController.assertCurrentRouteName(NavigationItem.Tasks.route)
    }

    @Test
    fun appNavHost_clickBtnButtons_navigatesToButtonsScreen() {
        composeTestRule.onNodeWithTag(ComposeTestTags.NAVIGATE_BUTTONS_TEST_TAG).performClick()
        navController.assertCurrentRouteName(NavigationItem.Buttons.route)
    }

    @Test
    fun appNavHost_clickBtnTexts_navigatesToTextsScreen() {
        composeTestRule.onNodeWithTag(ComposeTestTags.NAVIGATE_TEXTS_TEST_TAG).performClick()
        navController.assertCurrentRouteName(NavigationItem.Texts.route)
    }

    @Test
    fun appNavHost_clickBtnLists_navigatesToListsScreen() {
        composeTestRule.onNodeWithTag(ComposeTestTags.NAVIGATE_LISTS_TEST_TAG).performClick()
        navController.assertCurrentRouteName(NavigationItem.Lists.route)
    }
}
package com.example.uitestingcompose.buttons

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.uitestingcompose.constants.ComposeTestTags
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ButtonsScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setConfig() {
        composeTestRule.setContent {
            ButtonScreen()
        }
    }

    @Test
    fun btnButton1ShouldExists() {
        composeTestRule.onNodeWithContentDescription("btnButton1").assertExists()
    }

    @Test
    fun btnButton1ShouldDisplayed() {
        composeTestRule.onNodeWithContentDescription("btnButton1").assertIsDisplayed()
    }

    @Test
    fun btnButton1ShouldContainText() {
        composeTestRule.onNodeWithContentDescription("btnButton1").assertTextContains("Text Button")
    }

    @Test
    fun btnButton1ShouldHasClickAction() {
        composeTestRule.onNodeWithContentDescription("btnButton1").assertHasClickAction()
    }

    @Test
    fun btnButton1WhenClickShouldChangeText() {
        composeTestRule.onNodeWithContentDescription("btnButton1").performClick()
        composeTestRule.onNodeWithContentDescription("btnButton1").assertTextEquals("Button 1")
    }

    @Test
    fun checkBoxWhenStartShouldIsOff() {
        composeTestRule.onNodeWithTag(ComposeTestTags.CHECKBOX_TEST_TAG).assertIsOff()
    }

    @Test
    fun checkBoxWhenClickShouldIsOn() {
        composeTestRule.onNodeWithTag(ComposeTestTags.CHECKBOX_TEST_TAG).performClick().assertIsOn()
    }

    @Test
    fun switchWhenStartShouldIsOff() {
        composeTestRule.onNodeWithTag(ComposeTestTags.SWITCH_TEST_TAG).assertIsOff()
    }

    @Test
    fun switchWhenClickShouldIsOn() {
        composeTestRule.onNodeWithTag(ComposeTestTags.SWITCH_TEST_TAG).performClick().assertIsOn()
    }

    @Test
    fun btnButton2ShouldExists() {
        composeTestRule.onNodeWithContentDescription("btnButton2").assertExists()
    }

    @Test
    fun btnButton2ShouldDisplayed() {
        composeTestRule.onNodeWithContentDescription("btnButton2").assertIsDisplayed()
    }

    @Test
    fun btnButton2ShouldDoesNotExists() {
        composeTestRule.onNodeWithContentDescription("btnButton2").performClick()
            .assertDoesNotExist()
    }

}
package com.example.uitestingcompose.buttons

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasTestTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.atiurin.ultron.allure.config.UltronAllureConfig
import com.atiurin.ultron.core.compose.config.UltronComposeConfig
import com.atiurin.ultron.core.compose.createUltronComposeRule
import com.atiurin.ultron.core.config.UltronConfig
import com.atiurin.ultron.extensions.assertExists
import com.atiurin.ultron.extensions.assertHasClickAction
import com.atiurin.ultron.extensions.assertIsDisplayed
import com.atiurin.ultron.extensions.assertIsOff
import com.atiurin.ultron.extensions.assertTextContains
import com.atiurin.ultron.extensions.assertTextEquals
import com.atiurin.ultron.extensions.click
import com.example.uitestingcompose.constants.ComposeTestTags
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ButtonsScreenUltronTests {

    @get:Rule
    val composeTestRule = createUltronComposeRule<ComponentActivity>()

    @Before
    fun setConfig() {
        composeTestRule.setContent {
            ButtonScreen()
        }
        UltronConfig.applyRecommended()
        UltronAllureConfig.applyRecommended()
        UltronComposeConfig.applyRecommended()
    }

    @Test
    fun btnButton1ShouldExists() {
        hasContentDescription("btnButton1").assertExists()
    }

    @Test
    fun btnButton1ShouldDisplayed() {
        hasContentDescription("btnButton1").assertIsDisplayed()
    }

    @Test
    fun btnButton1ShouldContainText() {
        hasContentDescription("btnButton1").assertTextContains("Text Button")
    }

    @Test
    fun btnButton1ShouldHasClickAction() {
        hasContentDescription("btnButton1")
    }

    @Test
    fun btnButton1WhenClickShouldChangeText() {
        hasContentDescription("btnButton1").click()
        hasContentDescription("btnButton1").assertTextEquals("Button 1")
    }

    @Test
    fun checkBoxWhenStartShouldIsOff() {
        hasTestTag(ComposeTestTags.CHECKBOX_TEST_TAG).assertIsOff()
    }

    @Test
    fun checkBoxWhenClickShouldIsOn() {
        hasTestTag(ComposeTestTags.CHECKBOX_TEST_TAG).click().assertIsOn()
    }

    @Test
    fun switchWhenStartShouldIsOff() {
        hasTestTag(ComposeTestTags.SWITCH_TEST_TAG).assertIsOff()
    }

    @Test
    fun switchWhenClickShouldIsOn() {
        hasTestTag(ComposeTestTags.SWITCH_TEST_TAG).click().assertIsOn()
    }

    @Test
    fun btnButton2ShouldExists() {
        hasContentDescription("btnButton2").assertExists()
    }

    @Test
    fun btnButton2ShouldDisplayed() {
        hasContentDescription("btnButton2").assertIsDisplayed()
    }

    @Test
    fun btnButton2ShouldDoesNotExists() {
        hasContentDescription("btnButton2").click().assertDoesNotExist()
    }
}
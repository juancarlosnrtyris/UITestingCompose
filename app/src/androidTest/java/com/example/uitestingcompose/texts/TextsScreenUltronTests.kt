package com.example.uitestingcompose.texts

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.hasImeAction
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.text.input.ImeAction
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.atiurin.ultron.allure.config.UltronAllureConfig
import com.atiurin.ultron.core.compose.config.UltronComposeConfig
import com.atiurin.ultron.core.compose.createUltronComposeRule
import com.atiurin.ultron.core.config.UltronConfig
import com.atiurin.ultron.extensions.assertExists
import com.atiurin.ultron.extensions.assertIsDisplayed
import com.atiurin.ultron.extensions.assertTextEquals
import com.atiurin.ultron.extensions.imeAction
import com.atiurin.ultron.extensions.perform
import com.atiurin.ultron.extensions.setText
import com.example.uitestingcompose.constants.ComposeTestTags
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TextsScreenUltronTests {

    @get:Rule
    val composeTestRule = createUltronComposeRule<ComponentActivity>()

    @Before
    fun setConfig() {
        composeTestRule.setContent {
            TextScreen()
        }
        UltronConfig.applyRecommended()
        UltronAllureConfig.applyRecommended()
        UltronComposeConfig.applyRecommended()
    }

    @Test
    fun textWhenStartShouldBeEmpty() {
        hasTestTag(ComposeTestTags.TEXT_TEST_TAG).assertTextEquals("")
    }

    @Test
    fun textWhenInputTextShouldUpdated() {
        hasTestTag(ComposeTestTags.INPUT_TEST_TAG).setText("Prueba Test")
        hasTestTag(ComposeTestTags.TEXT_TEST_TAG).assertTextEquals("Prueba Test")
    }

    @Test
    fun inputTextWhenInputTextShouldUpdated() {
        hasTestTag(ComposeTestTags.INPUT_TEST_TAG).setText("Prueba Test")
        hasTestTag(ComposeTestTags.INPUT_TEST_TAG).assertTextEquals("Prueba Test")
    }

    @Test
    fun inputTextShouldDisplayed() {
        hasTestTag(ComposeTestTags.INPUT_TEST_TAG).assertIsDisplayed()
    }

    @Test
    fun textShouldExists() {
        hasTestTag(ComposeTestTags.TEXT_TEST_TAG).assertExists()
    }

    @Test
    fun inputTexthasImeAction() {
        hasTestTag(ComposeTestTags.INPUT_TEST_TAG).perform { hasImeAction(ImeAction.Done) }
    }

    @Test
    fun inputTextWhenImeActionShouldShowDisplayedText() {
        hasTestTag(ComposeTestTags.INPUT_TEST_TAG).imeAction()
        hasTestTag(ComposeTestTags.SECOND_TEXT_TEST_TAG).assertIsDisplayed()
    }
}
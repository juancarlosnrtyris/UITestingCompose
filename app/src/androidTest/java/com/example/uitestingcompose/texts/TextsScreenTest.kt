package com.example.uitestingcompose.texts

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasImeAction
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.text.input.ImeAction
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.uitestingcompose.constants.ComposeTestTags
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TextsScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setConfig(){
        composeTestRule.setContent {
            TextScreen()
        }
    }
    @Test
    fun textWhenStartShouldBeEmpty(){
        composeTestRule.onNodeWithTag(ComposeTestTags.TEXT_TEST_TAG).assertTextEquals("")
    }

    @Test
    fun textWhenInputTextShouldUpdated(){
        composeTestRule.onNodeWithTag(ComposeTestTags.INPUT_TEST_TAG).performTextInput("Prueba Test")
        composeTestRule.onNodeWithTag(ComposeTestTags.TEXT_TEST_TAG).assertTextEquals("Prueba Test")
    }

    @Test
    fun inputTextWhenInputTextShouldUpdated(){
        composeTestRule.onNodeWithTag(ComposeTestTags.INPUT_TEST_TAG).performTextInput("Prueba Test")
        composeTestRule.onNodeWithTag(ComposeTestTags.INPUT_TEST_TAG).assertTextEquals("Prueba Test")
    }

    @Test
    fun inputTextShouldDisplayed(){
        composeTestRule.onNodeWithTag(ComposeTestTags.INPUT_TEST_TAG).assertIsDisplayed()
    }

    @Test
    fun textShouldExists(){
        composeTestRule.onNodeWithTag(ComposeTestTags.TEXT_TEST_TAG).assertExists()
    }

    @Test
    fun inputTexthasImeAction(){
        composeTestRule.onNodeWithTag(ComposeTestTags.INPUT_TEST_TAG).performTouchInput { hasImeAction(ImeAction.Done) }
    }

    @Test
    fun inputTextWhenImeActionShouldShowDisplayedText(){
        composeTestRule.onNodeWithTag(ComposeTestTags.INPUT_TEST_TAG).performImeAction()
        composeTestRule.onNodeWithTag(ComposeTestTags.SECOND_TEXT_TEST_TAG).assertIsDisplayed()
    }


}
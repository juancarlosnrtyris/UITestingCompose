package com.example.uitestingcompose.lists

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performScrollToIndex
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.uitestingcompose.constants.ComposeTestTags
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenListIsEmptyShouldCountEquals0() {
        addListScreen(0)

        composeTestRule.onNodeWithTag(ComposeTestTags.LIST_TEST_TAG)
            .onChildren()
            .assertCountEquals(0)
    }

    @Test
    fun whenListHave20ItemsShouldCountEquals20() {
        addListScreen(20)

        composeTestRule.onNodeWithTag(ComposeTestTags.LIST_TEST_TAG)
            .onChildren()
            .assertCountEquals(20)
    }

    @Test
    fun whenDoesNotScrollItem119ShouldDoesNotExist() {
        addListScreen(120)

        composeTestRule.onNodeWithText("Item119").assertDoesNotExist()
    }

    @Test
    fun whenScrollToIndex119ShouldIsDisplayed() {
        addListScreen(120)

        composeTestRule.onNodeWithTag(ComposeTestTags.LIST_TEST_TAG).performScrollToIndex(119)

        composeTestRule.onNodeWithText("Item119").assertIsDisplayed()
    }

    private fun addListScreen(itemsCount: Int) {
        composeTestRule.setContent {
            ListScreen(itemsCount)
        }
    }
}
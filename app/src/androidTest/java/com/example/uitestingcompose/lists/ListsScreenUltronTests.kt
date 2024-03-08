package com.example.uitestingcompose.lists

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.atiurin.ultron.allure.config.UltronAllureConfig
import com.atiurin.ultron.core.compose.config.UltronComposeConfig
import com.atiurin.ultron.core.compose.createUltronComposeRule
import com.atiurin.ultron.core.compose.list.composeList
import com.atiurin.ultron.core.config.UltronConfig
import com.example.uitestingcompose.constants.ComposeTestTags
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListsScreenUltronTests {

    @get:Rule
    val composeTestRule = createUltronComposeRule<ComponentActivity>()

    @Before
    fun setConfig() {
        UltronConfig.applyRecommended()
        UltronAllureConfig.applyRecommended()
        UltronComposeConfig.applyRecommended()
    }

    @Test
    fun whenListIsEmptyShouldCountEquals0() {
        addListScreen(0)

        composeList(hasTestTag(ComposeTestTags.LIST_TEST_TAG))
            .assertVisibleItemsCount(0)
    }

    @Test
    fun whenListHave20ItemsShouldCountEquals20() {
        addListScreen(20)

        composeList(hasTestTag(ComposeTestTags.LIST_TEST_TAG))
            .assertVisibleItemsCount(20)
    }

    @Test
    fun whenScrollToIndex119ShouldIsDisplayed() {
        addListScreen(120)

        composeList(hasTestTag(ComposeTestTags.LIST_TEST_TAG))
            .item(hasText("Item119"))
            .assertIsDisplayed()
    }

    private fun addListScreen(itemsCount: Int) {
        composeTestRule.setContent {
            ListScreen(itemsCount)
        }
    }
}
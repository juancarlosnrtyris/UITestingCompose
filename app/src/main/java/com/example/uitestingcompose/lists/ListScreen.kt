package com.example.uitestingcompose.lists

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.example.uitestingcompose.constants.ComposeTestTags

@Composable
fun ListScreen(itemsCount:Int = 10){
    LazyColumn(modifier = Modifier.testTag(ComposeTestTags.LIST_TEST_TAG)) {
        items(itemsCount) { item ->
            Text(text = "Item$item")
        }
    }
}
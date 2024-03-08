package com.example.uitestingcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.uitestingcompose.buttons.ButtonScreen
import com.example.uitestingcompose.home.HomeScreen
import com.example.uitestingcompose.lists.ListScreen
import com.example.uitestingcompose.tasks.presentation.TasksScreen
import com.example.uitestingcompose.tasks.presentation.TasksViewModel
import com.example.uitestingcompose.texts.TextScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Home.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Home.route) {
            HomeScreen {
                navController.navigate(it)
            }
        }
        composable(NavigationItem.Buttons.route) {
            ButtonScreen()
        }
        composable(NavigationItem.Texts.route) {
            TextScreen()
        }
        composable(NavigationItem.Lists.route) {
            ListScreen()
        }
        composable(NavigationItem.Tasks.route) {
            val tasksViewModel:TasksViewModel = hiltViewModel()
            TasksScreen(tasksViewModel.state){tasksViewModel.sendUIEvent(it)}
        }
    }
}
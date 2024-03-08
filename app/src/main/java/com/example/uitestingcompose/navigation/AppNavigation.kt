package com.example.uitestingcompose.navigation

enum class Screen {
    HOME,
    TASKS,
    BUTTONS,
    TEXTS,
    LISTS
}
sealed class NavigationItem(val route: String) {
    data object Home : NavigationItem(Screen.HOME.name)
    data object Tasks : NavigationItem(Screen.TASKS.name)
    data object Buttons : NavigationItem(Screen.BUTTONS.name)
    data object Texts : NavigationItem(Screen.TEXTS.name)
    data object Lists : NavigationItem(Screen.LISTS.name)
}
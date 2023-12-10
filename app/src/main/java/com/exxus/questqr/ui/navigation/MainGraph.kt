package com.exxus.questqr.ui.navigation

sealed class Screen(val route: String) {
    data object Menu : Screen(route = "menu_screen")
    data object Scanner : Screen(route = "scanner_screen")
    data object Result : Screen(route = "result_screen")
}

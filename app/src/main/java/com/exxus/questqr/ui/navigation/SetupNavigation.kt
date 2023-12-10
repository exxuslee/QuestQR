package com.exxus.questqr.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.exxus.questqr.ui.screens.menu.MenuScreen
import com.exxus.questqr.ui.screens.result.ResultScreen
import com.exxus.questqr.ui.screens.scanner.ScannerScreen

@Composable
fun SetupNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Menu.route) {
        composable(Screen.Menu.route) { MenuScreen(navController) }
        composable(Screen.Scanner.route) { ScannerScreen(navController) }
        composable(Screen.Result.route) { ResultScreen(navController) }
    }
}
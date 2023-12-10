package com.exxus.questqr.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.exxus.questqr.ui.screens.scanner.ScannerScreen

object Routes {
    const val SCANNER = "scanner"
}

@Composable
fun SimpleScannerNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.SCANNER
    ) {
       composable(route = Routes.SCANNER) {
           ScannerScreen()
       }
    }
}
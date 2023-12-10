package com.exxus.questqr.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.exxus.questqr.ui.navigation.SetupNavigation
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.exxus.questqr.ui.theme.Black700
import com.exxus.questqr.ui.theme.QuestQRTheme

@Composable
fun QuestQRApp() {
    QuestQRTheme {
        val navController = rememberNavController()
        val systemUiController = rememberSystemUiController()

        SideEffect {
            systemUiController.setSystemBarsColor(Black700, false)
        }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SetupNavigation(navController = navController)
        }
    }
}
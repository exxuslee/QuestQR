package com.exxus.questqr.ui.screens.result

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.exxus.questqr.ui.theme.QuestQRTheme

@Composable
fun ResultScreen(navController: NavHostController) {
    Text(text = "finish")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    QuestQRTheme() {
        ResultScreen(navController)
    }
}

package com.exxus.questqr.ui.screens.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.exxus.questqr.ui.navigation.Screen
import com.exxus.questqr.ui.theme.QuestQRTheme

@Composable
fun MenuScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
                .background(Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "QR", modifier = Modifier.padding(48.dp))

            Button(onClick = {
                navController.navigate(Screen.Scanner.route)
            }) {
                Text(text = "Na game")
            }

            Button(onClick = {
                navController.navigate(Screen.Scanner.route)
            }) {
                Text(text = "Ni game")
            }

            Button(onClick = {
                navController.navigate(Screen.Result.route)
            }) {
                Text(text = "settings")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    QuestQRTheme() {
        MenuScreen(navController)
    }
}
package com.exxus.questqr.ui.screens.menu

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.exxus.questqr.ui.navigation.Screen
import com.exxus.questqr.ui.theme.QuestQRTheme
import kotlinx.coroutines.delay

@Composable
fun MenuScreen(navController: NavHostController) {
    val viewModel: MenuViewModel =
        viewModel(factory = MenuViewModelFactory())


    var color by remember { mutableStateOf(Color.Red) }
    LaunchedEffect(true) {
        while (true) {
            color = if (color == Color.Red) Color.Blue else Color.Red
            delay(300)
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            for (i in 0..size.height.toInt() step 16) {
                drawLine(
                    color = color, start = Offset(0f, i.toFloat()),
                    strokeWidth = 8f, end = Offset(size.height, i.toFloat()),
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
                .background(Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "menu", modifier = Modifier.padding(48.dp))

            Button(onClick = {
                navController.navigate(Screen.Scanner.route)
            }) {
                Text(text = "continue game")
            }

            Card(
                modifier = Modifier
                    .clickable {  }
                    .background(Color.White),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "New game",
                    modifier = Modifier.padding(8.dp)
                )
            }

            Button(onClick = {})
            {
                Text(text = "load game")
            }

            Button(onClick = {

//            navController.navigate(Screen.Settings.route)
            }) {
                Text(text = "delete")
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

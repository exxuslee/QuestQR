package com.exxus.questqr.ui.screens.menu

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.exxus.questqr.MyPreferences
import com.exxus.questqr.R
import com.exxus.questqr.ui.navigation.Screen
import com.exxus.questqr.ui.theme.QuestQRTheme
import java.time.Duration


@Composable
fun MenuScreen(navController: NavHostController) {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.main),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(164.dp))
            Button(
                modifier = Modifier.padding(end = 164.dp),
                onClick = {
                    if (System.currentTimeMillis() > 1703088000000) {
                        val myPreferences = MyPreferences(context)
                        myPreferences.saveBoolean("reverse", true)
                        navController.navigate(Screen.Scanner.route)
                    } else {
                        Toast.makeText(context, "Время игр ещё не наступило", Toast.LENGTH_LONG)
                            .show()
                    }

                }) {
                Text(
                    text = "Nadiya",
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.height(100.dp))
            Button(
                modifier = Modifier.padding(start = 164.dp),
                onClick = {
                    if (System.currentTimeMillis() > 1703088000000) {
                        val myPreferences = MyPreferences(context)
                        myPreferences.saveBoolean("reverse", false)
                        navController.navigate(Screen.Scanner.route)
                    } else {
                        Toast.makeText(context, "Время игр ещё не наступило", Toast.LENGTH_LONG)
                            .show()
                    }
                }) {
                Text(
                    text = "Nikita",
                    fontSize = 18.sp
                )
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

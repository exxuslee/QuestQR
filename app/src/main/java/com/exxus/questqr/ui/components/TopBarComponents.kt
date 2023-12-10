package com.exxus.questqr.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.exxus.questqr.ui.theme.Black700
import com.exxus.questqr.ui.theme.QuestQRTheme
import com.exxus.questqr.R

@Composable
fun TopBarComponents() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(
                Brush.verticalGradient(colors = listOf(Black700, Color.Transparent))
            )
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.questqr),
            contentDescription = null,
            modifier = Modifier.requiredSize(180.dp),
        )
    }
}

@Preview("Simple scanner top bar", showBackground = true)
@Composable
private fun TopBarComponentsPreview() {
    QuestQRTheme {
        TopBarComponents()
    }
}
package com.exxus.questqr.ui.screens.scanner.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.exxus.questqr.R
import com.exxus.questqr.data.fake.fakeScan
import com.exxus.questqr.model.Scan
import com.exxus.questqr.model.ScanType
import com.exxus.questqr.ui.theme.BaseDP
import com.exxus.questqr.ui.theme.ElevationDP
import com.exxus.questqr.ui.theme.QuestQRTheme
import com.exxus.questqr.ui.theme.SpaceDP

@Composable
fun ScanSheet(
    scan: Scan,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(BaseDP),
        modifier = modifier
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_bottom_handle),
            contentDescription = null,
            tint = Color.LightGray,
            modifier = Modifier
                .padding(top = SpaceDP)
                .align(Alignment.CenterHorizontally)
        )
        if (scan.displayValue.isNotBlank()) {
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = ElevationDP,
                modifier = Modifier.fillMaxWidth()
            ) {
                val painter = painterResource(id = when (scan.displayPhoto) {
                    1 -> R.drawable.ic_1
                    else -> R.drawable.questqr
                })
                Image(
                    painter = painter,
                    contentDescription = null)
                Text(
                    text = scan.displayValue,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(SpaceDP)
                )
            }
            Spacer(modifier = Modifier.height(BaseDP))
        }
    }
}

@Preview("Scan sheet", showBackground = true)
@Composable
private fun ScanSheetPreview() {
    QuestQRTheme {
        ScanSheet(
            scan = fakeScan.copy( scanType = ScanType.Url ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = BaseDP)
        )
    }
}
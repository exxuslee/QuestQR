package com.exxus.questqr.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.exxus.questqr.MyPreferences
import com.exxus.questqr.R
import com.exxus.questqr.data.fake.fakeScan
import com.exxus.questqr.model.Scan
import com.exxus.questqr.model.ScanType
import com.exxus.questqr.ui.theme.BaseDP
import com.exxus.questqr.ui.theme.ElevationDP
import com.exxus.questqr.ui.theme.QuestQRTheme
import com.exxus.questqr.ui.theme.SpaceDP
import kotlin.math.abs

@Composable
fun ScanSheet(
    scan: Scan,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

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
                val myPreferences = MyPreferences(context)
                val reverse = myPreferences.getBoolean("reverse", false)
                val start = if (reverse) 23 else 0
                Log.d("ScanSheet", start.toString())

                val painter = painterResource(id = when (scan.displayPhoto) {
                    abs(start - 1) -> R.drawable.ic_1
                    abs(start - 2) -> R.drawable.ic_2
                    abs(start - 3) -> R.drawable.ic_3
                    abs(start - 4)-> R.drawable.ic_4
                    abs(start - 5) -> R.drawable.ic_5
                    abs(start - 6) -> R.drawable.ic_6
                    abs(start - 7) -> R.drawable.ic_7
                    abs(start - 8) -> R.drawable.ic_8
                    abs(start - 9) -> R.drawable.ic_9
                    abs(start - 10) -> R.drawable.ic_10
                    abs(start - 11) -> R.drawable.ic_11
                    abs(start - 12) -> R.drawable.ic_12
                    abs(start - 13) -> R.drawable.ic_13
                    abs(start - 14) -> R.drawable.ic_14
                    abs(start - 15) -> R.drawable.ic_15
                    abs(start - 16) -> R.drawable.ic_16
                    abs(start - 17) -> R.drawable.ic_17
                    abs(start - 18) -> R.drawable.ic_18
                    abs(start - 19) -> R.drawable.ic_19
                    abs(start - 20) -> R.drawable.ic_20
                    abs(start - 21) -> R.drawable.ic_21
                    abs(start - 22) -> R.drawable.ic_22
                    abs(start - 23) -> R.drawable.ic_23
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
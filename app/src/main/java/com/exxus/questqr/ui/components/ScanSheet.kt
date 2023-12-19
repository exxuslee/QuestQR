package com.exxus.questqr.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
                val start by remember {
                    mutableStateOf(
                        if (MyPreferences(context).getBoolean("reverse", false)) -1
                        else 1
                    )
                }
                val painter = painterResource(
                    id = when (abs(scan.displayPhoto + start)) {
                        0 -> R.drawable.fin3
                        1 -> R.drawable.ic_1
                        2 -> R.drawable.ic_2
                        3 -> R.drawable.ic_3
                        4 -> R.drawable.ic_4
                        5 -> R.drawable.ic_5
                        6 -> R.drawable.ic_6
                        7 -> R.drawable.ic_7
                        8 -> R.drawable.ic_8
                        9 -> R.drawable.ic_9
                        10 -> R.drawable.ic_10
                        11 -> R.drawable.ic_11
                        12 -> R.drawable.ic_12
                        13 -> R.drawable.ic_13
                        14 -> R.drawable.ic_14
                        15 -> R.drawable.ic_15
                        16 -> R.drawable.ic_16
                        17 -> R.drawable.ic_17
                        18 -> R.drawable.ic_18
                        19 -> R.drawable.ic_19
                        20 -> R.drawable.ic_20
                        21 -> R.drawable.ic_21
                        22 -> R.drawable.ic_22
                        23 -> R.drawable.ic_23
                        24 -> R.drawable.ic_24
                        25 -> R.drawable.ic_25
                        26 -> R.drawable.ic_26
                        27 -> R.drawable.ic_27
                        28 -> R.drawable.ic_28
                        29 -> R.drawable.ic_29
                        30 -> R.drawable.ic_30
                        31 -> R.drawable.ic_31
                        32 -> R.drawable.ic_32
                        33 -> R.drawable.ic_33
                        34 -> R.drawable.ic_34
                        35 -> R.drawable.ic_35
                        36 -> R.drawable.ic_36
                        37 -> R.drawable.ic_37
                        38 -> R.drawable.fin1
                        else -> R.drawable.questqr
                    }
                )
                Image(painter = painter, contentDescription = null)
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
            scan = fakeScan.copy(scanType = ScanType.Url),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = BaseDP)
        )
    }
}
package com.exxus.questqr.model

import androidx.annotation.StringRes

data class Scan(
    val displayValue: String,
    val displayPhoto: Int,
    @StringRes val scanFormatId: Int,
    val scanType: ScanType
)

enum class ScanType {
    Text,
    Url
}

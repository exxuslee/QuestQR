package com.exxus.questqr.data.fake

import com.exxus.questqr.R
import com.exxus.questqr.model.Scan
import com.exxus.questqr.model.ScanType

val fakeScan = Scan(
    displayValue = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.",
    displayPhoto = 1,
    scanFormatId = R.string.scan_format_qr_code,
    scanType = ScanType.Text
)
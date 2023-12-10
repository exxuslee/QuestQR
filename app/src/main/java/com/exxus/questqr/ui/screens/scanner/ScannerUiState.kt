package com.exxus.questqr.ui.screens.scanner

import androidx.camera.view.PreviewView
import com.exxus.questqr.model.Scan

data class ScannerUiState(
    val previewView: PreviewView? = null,
    val scan: Scan? = null,
    val showBottomSheet: Boolean = false,
    val showCameraRequiredDialog: Boolean = false
)

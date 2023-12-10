package com.exxus.questqr.ui.screens.scanner

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.exxus.questqr.R
import com.exxus.questqr.ui.components.ScanSheet
import com.exxus.questqr.ui.components.TopBarComponents
import com.exxus.questqr.ui.dialogs.CameraRequiredDialog
import com.exxus.questqr.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ScannerScreen(
    navController: NavHostController,
    viewModel: ScannerViewModel = hiltViewModel()
) {
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val lifecycleOwner = LocalLifecycleOwner.current
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsState()

    val hapticFeedback = LocalHapticFeedback.current
    val activity = remember(context) {
        context as Activity
    }

    BackHandler(enabled = bottomSheetState.isVisible) {
        coroutineScope.launch {
            bottomSheetState.hide()
        }
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted ->
            if (granted) {
                viewModel.onEvent(ScannerEvent.CreatePreviewView(lifecycleOwner))
            } else {
                viewModel.onEvent(ScannerEvent.CameraRequiredDialogVisibility(show = true))
            }
        }
    )

    LaunchedEffect(key1 = bottomSheetState.currentValue) {
        if (uiState.previewView != null && !bottomSheetState.isVisible) {
            viewModel.onEvent(ScannerEvent.BottomSheetHidden)
        }
    }

    LaunchedEffect(key1 = lifecycleOwner) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            viewModel.onEvent(ScannerEvent.CreatePreviewView(lifecycleOwner))
        } else {
            permissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    SideEffect {
        if (uiState.showBottomSheet) {
            hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
            coroutineScope.launch { if (!bottomSheetState.isVisible) bottomSheetState.show() }
            viewModel.onEvent(ScannerEvent.BottomSheetShown)
        }
    }

    if (uiState.showCameraRequiredDialog) {
        CameraRequiredDialog(
            onContinueClicked = {
                viewModel.onEvent(ScannerEvent.CameraRequiredDialogVisibility(show = false))
                permissionLauncher.launch(Manifest.permission.CAMERA)
            },
            onExitClicked = {
                viewModel.onEvent(ScannerEvent.CameraRequiredDialogVisibility(show = false))
                activity.finish()
            }
        )
    }

    ScannerScreen(
        bottomSheetState = bottomSheetState,
        uiState = uiState,
        context = context
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ScannerScreen(
    bottomSheetState: ModalBottomSheetState,
    uiState: ScannerUiState,
    context: Context
) {
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetShape = BottomSheetShape,
        scrimColor = Color.Transparent,
        sheetContent = {
            uiState.scan?.let {
                ScanSheet(
                    scan = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = BaseDP)
                )
            } ?: Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Black200)
        ) {
            if (uiState.previewView != null) {
                AndroidView(
                    factory = { uiState.previewView },
                    modifier = Modifier.fillMaxSize()
                )
            }
            Surface(
                color = Black700.copy(alpha = 0.7f),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .padding(BaseDP)
                    .align(Alignment.BottomCenter)
            ) {
                Text(
                    text = stringResource(id = R.string.scan_message),
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = BaseDP)
                )
            }
            TopBarComponents()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview("Scanner screen", showBackground = true)
@Composable
private fun ScannerScreenPreview() {
    QuestQRTheme {
        ScannerScreen(
            bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden),
            uiState = ScannerUiState(),
            context = LocalContext.current
        )
    }
}
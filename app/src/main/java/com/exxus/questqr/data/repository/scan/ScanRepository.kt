package com.exxus.questqr.data.repository.scan

import androidx.camera.view.PreviewView
import androidx.lifecycle.LifecycleOwner
import com.exxus.questqr.model.Scan
import kotlinx.coroutines.flow.Flow

interface ScanRepository {

    fun getLatestScan(): Flow<Scan>

    suspend fun getCameraPreview(lifecycleOwner: LifecycleOwner): PreviewView

    suspend fun pauseScan()

    suspend fun resumeScan()

}
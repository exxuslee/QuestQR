package com.exxus.questqr.di

import com.exxus.questqr.data.local.ml_camera_scan.ScanLDS
import com.exxus.questqr.data.repository.scan.impl.ScanLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindsScanLocalDataSource(
        scanLDS: ScanLDS
    ): ScanLocalDataSource

}
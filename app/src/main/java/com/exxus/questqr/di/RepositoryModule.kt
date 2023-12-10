package com.exxus.questqr.di

import com.exxus.questqr.data.repository.scan.ScanRepository
import com.exxus.questqr.data.repository.scan.impl.ScanRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsScanRepository(
        scanRepositoryImpl: ScanRepositoryImpl
    ): ScanRepository

}
package com.example.core.di

import com.example.core.model.AppConfig
import com.example.core.di.qualifier.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppConfigModule {

    @Singleton
    @Provides
    fun provideAppConfig(
        @DeviceId deviceId: String,
        @AppVersion appVersion: String,
        @AppId appId: String,
        @AuthKey authKey: String,
        @MasterKey masterKey: String,
        @DateOfBuild dateOfBuild: String,
        @IsDevOrEnv isDevOrEnv: Boolean
    ) = AppConfig(
        applicationId = appId,
        version = appVersion,
        authKey = authKey,
        masterKey = masterKey,
        deviceId = deviceId,
        dateOfBuild = dateOfBuild,
        isDevEnv = isDevOrEnv
    )
}

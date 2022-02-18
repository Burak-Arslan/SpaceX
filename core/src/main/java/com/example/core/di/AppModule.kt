package com.example.core.di

import android.content.Context
import com.example.core.di.qualifier.*
import com.example.core.util.AppInfoUtil
import com.example.core.util.CacheManager
import com.example.core.di.qualifier.ApiUrl
import com.example.core.di.qualifier.AppVersion
import com.example.core.di.qualifier.DeviceId
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @DeviceId
    @Provides
    fun provideDeviceId(
        @ApplicationContext context: Context
    ) = AppInfoUtil.getDeviceId(context)

    @AppVersion
    @Provides
    fun provideAppVersion(@ApplicationContext context: Context) =
        AppInfoUtil.getSoftwareVersion(context)

    @ApiUrl
    @Provides
    fun provideApiUrl() = "DUMMY"

    @AppId
    @Provides
    fun provideAppId() = "DUMMY"

    @AuthKey
    @Provides
    fun provideAuthKey() = "DUMMY"

    @MasterKey
    @Provides
    fun provideMasterKey() = "DUMMY"

    @DateOfBuild
    @Provides
    fun provideDateOfBuild() = "DUMMY"

    @IsDevOrEnv
    @Provides
    fun provideIsDevOrEnv() = false

    @Singleton
    @Provides
    fun provideCacheManager() = CacheManager()
}

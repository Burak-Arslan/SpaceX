package com.example.core.di

import android.content.Context
import com.example.core.base.constants.CommonPreferences
import com.example.core.base.constants.CommonPreferencesImpl
import com.example.core.base.constants.PreferenceWrapper
import com.example.core.model.AppConfig
import com.example.core.util.GsonProvider
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Singleton
    @Provides
    fun providePreferenceWrapper(
        @ApplicationContext context: Context,
        gson: Gson,
        appConfig: AppConfig
    ) = PreferenceWrapper(context, gson, appConfig)

    @Singleton
    @Provides
    fun provideCommonPreferences(
        wrapper: PreferenceWrapper
    ): CommonPreferences = CommonPreferencesImpl(wrapper)


    @Singleton
    @Provides
    fun provideGson() = GsonProvider.gson
}

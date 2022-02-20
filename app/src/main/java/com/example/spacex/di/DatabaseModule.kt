package com.example.spacex.di

import android.content.Context
import androidx.room.Room
import com.example.spacex.data.RocketDatabase
import com.example.spacex.data.RocketInfoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideRocketDao(appDatabase: RocketDatabase): RocketInfoDao {
        return appDatabase.rocketDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): RocketDatabase {
        return Room.databaseBuilder(
            appContext.applicationContext,
            RocketDatabase::class.java,
            "rocket_database"
        ).build()
    }
}

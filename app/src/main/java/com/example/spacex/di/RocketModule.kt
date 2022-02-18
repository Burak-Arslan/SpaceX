package com.example.spacex.di

import com.example.core.base.CacheManager
import com.example.spacex.repository.service.spacexlist.SpaceXListService
import com.example.spacex.repository.service.spacexlist.SpaceXRepository
import com.example.spacex.repository.service.spacexlist.SpaceXRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RocketModule {

    @Provides
    @Singleton
    fun provideSpaceXRocketListService(retrofit: Retrofit): SpaceXListService = retrofit.create(SpaceXListService::class.java)

    @Provides
    @Singleton
    fun provideSpaceXRocketListRepository(
        service: SpaceXListService,
        cacheManager: CacheManager
    ): SpaceXRepository = SpaceXRepositoryImpl(service,cacheManager)

}
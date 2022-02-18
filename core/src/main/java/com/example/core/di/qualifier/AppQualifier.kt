package com.example.core.di.qualifier

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DeviceId

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApiUrl

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AppVersion

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AppId

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthKey

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MasterKey

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DateOfBuild

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IsDevOrEnv

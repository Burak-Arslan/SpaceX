package com.example.core.model

import com.example.core.util.AppInfoUtil

data class AppConfig(
    val applicationId: String,
    val version: String,
    val authKey: String,
    val masterKey: String,
    val deviceId: String,
    val channel: String = AppInfoUtil.getApplicationChannel(),
    val deviceModel: String = AppInfoUtil.getDeviceModel(),
    val dateOfBuild: String,
    val isDevEnv: Boolean
)

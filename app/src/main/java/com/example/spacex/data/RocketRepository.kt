package com.example.spacex.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RocketRepository @Inject constructor(private val rocketInfoDao: RocketInfoDao) {

    fun allList(): Flow<List<RocketInfo>> {
        return rocketInfoDao.readAllRocketData()
    }

    fun addRocket(rocketInfo: RocketInfo) {
        rocketInfoDao.addRocket(rocketInfo)
    }

    fun deleteRocket(rocketInfo: RocketInfo) {
        rocketInfoDao.rocketDelete(rocketInfo)
    }
}
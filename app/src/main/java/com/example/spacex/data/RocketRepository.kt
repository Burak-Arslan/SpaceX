package com.example.spacex.data

import androidx.lifecycle.LiveData

class RocketRepository(private val rocketInfoDao: RocketInfoDao) {

    suspend fun allList(): LiveData<List<RocketInfo>> {
        return rocketInfoDao.readAllRocketData()
    }

    suspend fun addRocket(rocketInfo: RocketInfo) {
        rocketInfoDao.addRocket(rocketInfo)
    }

    suspend fun deleteRocket(rocketInfo: RocketInfo) {
        rocketInfoDao.rocketDelete(rocketInfo)
    }
}
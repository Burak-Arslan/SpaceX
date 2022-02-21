package com.example.spacex.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RocketRepository @Inject constructor(private val rocketInfoDao: RocketInfoDao) {

    fun allList(): Flow<List<RocketInfo>> {
        return rocketInfoDao.readAllRocketData()
    }

   suspend fun addAll(rocketInfo: List<RocketInfo>) {
        rocketInfoDao.addAllRocket(rocketInfo)
    }

     fun readAllfavorite():Flow<List<RocketInfo>>{
        return rocketInfoDao.readAllFavorite()
    }

    fun udpateRocket(rocketInfo: RocketInfo) {
        rocketInfoDao.updateRocket(rocketInfo)
    }
}
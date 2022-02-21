package com.example.spacex.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RocketInfoDao {

    @Update
    fun updateRocket(rocketInfo: RocketInfo)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAllRocket(rocketInfo: List<RocketInfo>)

    @Query("SELECT * FROM rocket_info ORDER BY id ASC")
    fun readAllRocketData(): Flow<List<RocketInfo>>

    @Query("SELECT * FROM rocket_info WHERE isfavorite = 1 ORDER BY id ASC")
    fun readAllFavorite(): Flow<List<RocketInfo>>

    @Query("DELETE FROM rocket_info")
    suspend fun deleteAllRocket()
}
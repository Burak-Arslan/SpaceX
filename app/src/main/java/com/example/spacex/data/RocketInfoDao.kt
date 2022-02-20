package com.example.spacex.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RocketInfoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRocket(rocketInfo: RocketInfo)

    @Query("SELECT * FROM rocket_info ORDER BY id ASC")
    suspend fun readAllRocketData(): LiveData<List<RocketInfo>>

    @Delete
    suspend fun rocketDelete(rocketInfo: RocketInfo)

}
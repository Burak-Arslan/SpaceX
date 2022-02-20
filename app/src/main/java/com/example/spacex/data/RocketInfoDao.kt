package com.example.spacex.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RocketInfoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun addRocket(rocketInfo: RocketInfo)

    @Query("SELECT * FROM rocket_info ORDER BY id ASC")
    fun readAllRocketData(): Flow<List<RocketInfo>>

    @Delete
     fun rocketDelete(rocketInfo: RocketInfo)

}
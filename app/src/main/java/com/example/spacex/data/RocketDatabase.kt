package com.example.spacex.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RocketInfo::class], version = 1, exportSchema = false)
abstract class RocketDatabase : RoomDatabase() {

    abstract fun rocketDao(): RocketInfoDao

}
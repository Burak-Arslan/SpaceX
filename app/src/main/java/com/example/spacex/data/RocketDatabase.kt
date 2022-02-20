package com.example.spacex.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RocketInfo::class], version = 1, exportSchema = false)
abstract class RocketDatabase : RoomDatabase() {

    abstract fun rocketDao(): RocketInfoDao

    companion object {
        @Volatile
        private var INSTANCE: RocketDatabase? = null

        fun getDatabase(context: Context): RocketDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RocketDatabase::class.java,
                    "rocket_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
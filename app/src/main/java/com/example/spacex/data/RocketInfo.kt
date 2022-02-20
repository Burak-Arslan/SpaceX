package com.example.spacex.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rocket_info")
data class RocketInfo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "rocketName")
    val rocketName: String,
    @ColumnInfo(name = "country")
    val country: String,
    @ColumnInfo(name = "company")
    val company: String,
    @ColumnInfo(name = "isfavorite")
    val isfavorite: Boolean,
    @ColumnInfo(name = "imageUrl")
    val imageUrl: String
)
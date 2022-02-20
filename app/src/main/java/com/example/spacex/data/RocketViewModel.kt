package com.example.spacex.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RocketViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: RocketRepository

    init {
        val rocketDao = RocketDatabase.getDatabase(application).rocketDao()
        repository = RocketRepository(rocketDao)
    }

    fun addRocket(rocketInfo: RocketInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addRocket(rocketInfo)
        }
    }

    fun deleteRocket(rocketInfo: RocketInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteRocket(rocketInfo)
        }
    }
}
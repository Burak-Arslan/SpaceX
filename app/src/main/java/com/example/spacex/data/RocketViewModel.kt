package com.example.spacex.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RocketViewModel(private val repository: RocketRepository) : ViewModel() {

    fun getAllList() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.allList()
        }
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
package com.example.spacex.ui.favori

import android.app.Application
import com.example.core.base.BaseViewModel
import com.example.spacex.data.RocketDatabase
import com.example.spacex.data.RocketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FRFavoriteVM @Inject constructor(private val application: Application) : BaseViewModel() {

    lateinit var repository: RocketRepository

    fun initVM() {
        val rocketDao = RocketDatabase.getDatabase(application).rocketDao()
        repository = RocketRepository(rocketDao)
        GlobalScope.launch {
            getlAllList()
        }
    }

    suspend fun getlAllList() {
        repository.allList()
    }
}
package com.example.spacex.ui.favori

import android.util.Log
import com.example.core.base.BaseViewModel
import com.example.spacex.data.RocketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FRFavoriteVM @Inject constructor(private val repository: RocketRepository) : BaseViewModel() {

    fun getAllList() {
        GlobalScope.launch {
            repository.allList().collect {
                var test = it.size.toString()
                Log.e("TEST", test)
            }
        }
    }
}
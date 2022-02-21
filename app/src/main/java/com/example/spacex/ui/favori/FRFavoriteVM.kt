package com.example.spacex.ui.favori

import com.example.core.base.BaseViewModel
import com.example.core.util.SingleLiveEvent
import com.example.spacex.data.RocketInfo
import com.example.spacex.data.RocketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FRFavoriteVM @Inject constructor(private val repository: RocketRepository) : BaseViewModel() {

    var allList = SingleLiveEvent<List<RocketInfo>>()

    fun getAllList() {
        GlobalScope.launch {
            repository.readAllfavorite().collect {
                allList.postValue(it)
            }
        }
    }
}
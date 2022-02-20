package com.example.spacex.ui.home

import com.example.core.base.BaseViewModel
import com.example.core.extension.launch
import com.example.core.util.SingleLiveEvent
import com.example.spacex.data.RocketInfo
import com.example.spacex.data.RocketRepository
import com.example.spacex.domain.spacexlist.SpaceXListUseCase
import com.example.spacex.domain.spacexlist.uimodel.RocketListUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FRHomeVM @Inject constructor(
    private val useCase: SpaceXListUseCase,
    private val repository: RocketRepository
) : BaseViewModel() {

    var rocketList = SingleLiveEvent<List<RocketListUI>>()

    fun initVM() {
        getRocketList()
    }

    private fun getRocketList() = launch {
        useCase(Unit)
            .onStart { showLoading() }
            .onCompletion { hideLoading() }
            .collect {
                rocketList.postValue(it)
            }
    }

    fun addRocket(item: RocketListUI) {
        GlobalScope.launch {
            repository.addRocket(
                RocketInfo(
                    0,
                    rocketName = item.name ?: "",
                    country = item.country ?: "",
                    company = item.company ?: ""
                )
            )
        }
    }
}
package com.example.spacex.ui.home

import com.example.core.base.BaseViewModel
import com.example.core.extension.launch
import com.example.core.util.SingleLiveEvent
import com.example.spacex.domain.spacexlist.SpaceXListUseCase
import com.example.spacex.domain.spacexlist.uimodel.RocketListUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class FRHomeVM @Inject constructor(
    private val useCase: SpaceXListUseCase
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
}
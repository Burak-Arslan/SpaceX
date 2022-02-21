package com.example.spacex.ui.home

import androidx.annotation.VisibleForTesting
import com.example.core.base.BaseViewModel
import com.example.core.extension.launch
import com.example.core.util.SingleLiveEvent
import com.example.spacex.data.RocketInfo
import com.example.spacex.data.RocketRepository
import com.example.spacex.domain.spacexlist.SpaceXListUseCase
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

    var rocketList = SingleLiveEvent<List<RocketInfo>>()

    fun initVM() {
        getRocketList()
    }

    @VisibleForTesting
    internal fun getRocketList() = launch {
        useCase(Unit)
            .onStart { showLoading() }
            .onCompletion { hideLoading() }
            .collect { item ->
                repository.allList().collect { list ->
                    if (list.isNotEmpty()) {
                        rocketList.postValue(list)
                    } else {
                        repository.addAll(item)
                        rocketList.postValue(item)
                    }
                }
            }
    }

    fun addRocket(item: RocketInfo) {
        GlobalScope.launch {
            repository.udpateRocket(updateRocketItem(item, !item.isfavorite))
        }
    }

    fun updateRocketItem(item: RocketInfo, isFavorite: Boolean): RocketInfo {
        return RocketInfo(
            item.id,
            item.rocketName,
            item.country,
            item.company,
            isFavorite,
            item.imageUrl,
            item.description
        )
    }

    fun allDeleteRocket() {
        GlobalScope.launch {
            repository.deleteAllRocket()
        }
    }
}
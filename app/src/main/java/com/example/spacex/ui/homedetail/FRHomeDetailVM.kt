package com.example.spacex.ui.homedetail

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
class FRHomeDetailVM @Inject constructor() : BaseViewModel(){

    var currentRocketInfo: SingleLiveEvent<RocketListUI>? = null
    var name:SingleLiveEvent<String>? = null

    fun setValue(){
     name?.postValue(currentRocketInfo?.value?.name!!)
    }
}
package com.example.spacex.ui.homedetail

import com.example.core.base.BaseViewModel
import com.example.core.util.SingleLiveEvent
import com.example.spacex.data.RocketInfo
import com.example.spacex.domain.spacexlist.uimodel.RocketImageListUI
import com.example.spacex.domain.spacexlist.uimodel.RocketListUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FRHomeDetailVM @Inject constructor() : BaseViewModel(){

    var selectedRocketUI: RocketInfo? = null

    var title = SingleLiveEvent<String>()
    var country = SingleLiveEvent<String>()
    var company = SingleLiveEvent<String>()
    var description = SingleLiveEvent<String>()

    fun setValue(){
        title.postValue(selectedRocketUI?.rocketName)
        country.postValue(selectedRocketUI?.country)
        company.postValue(selectedRocketUI?.company)
        description.postValue(selectedRocketUI?.description)
    }
}
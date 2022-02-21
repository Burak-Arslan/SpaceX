package com.example.spacex.ui

import androidx.lifecycle.SavedStateHandle
import com.example.core.base.BaseViewModel
import com.example.core.util.SingleLiveEvent
import com.example.spacex.data.RocketInfo
import com.example.spacex.domain.spacexlist.uimodel.RocketListUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class SharedRocketVM @Inject constructor(
    val handle: SavedStateHandle
) : BaseViewModel() {

    var selectedRocketUI: RocketInfo? = null
}

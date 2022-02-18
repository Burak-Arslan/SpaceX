package com.example.spacex.ui.splash

import com.example.core.base.BaseViewModel
import com.example.core.extension.launch
import com.example.core.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class FRSplashVM @Inject constructor() : BaseViewModel() {

    var navigationNextValue = SingleLiveEvent(false)

    companion object {
        var splashDisplayDuration = 2500L
    }

    fun initVM() {
        launch {
            delay(splashDisplayDuration)
            nextNavigate()
        }
    }

    private fun nextNavigate() {
        navigationNextValue.postValue(true)
    }
}
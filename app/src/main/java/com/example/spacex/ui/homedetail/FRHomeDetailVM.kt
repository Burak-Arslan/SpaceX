package com.example.spacex.ui.homedetail

import com.example.core.base.BaseViewModel
import com.example.spacex.data.RocketInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FRHomeDetailVM @Inject constructor() : BaseViewModel() {

    var title = MutableStateFlow<String?>("")
    var country = MutableStateFlow<String?>("")
    var company = MutableStateFlow<String?>("")
    var description = MutableStateFlow<String?>("")
    var isFavorite = MutableStateFlow<String?>("")

    fun setValue(selectedRocketUI: RocketInfo?) {
        GlobalScope.launch {
            title.tryEmit(selectedRocketUI?.rocketName)
            country.tryEmit(selectedRocketUI?.country)
            company.tryEmit(selectedRocketUI?.company)
            description.tryEmit(selectedRocketUI?.description)
            if (selectedRocketUI?.isfavorite == true) {
                isFavorite.emit("Favori")
            } else {
                isFavorite.emit("Favori Değil")
            }
        }
    }
}
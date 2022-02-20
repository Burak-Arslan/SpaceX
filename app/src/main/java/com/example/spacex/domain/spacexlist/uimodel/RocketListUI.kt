package com.example.spacex.domain.spacexlist.uimodel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RocketListUI(
    var imageList: List<String>? = null,
    var name: String? = null,
    var active: Boolean? = null,
    var firstFlight: String? = null,
    var country: String? = null,
    var company: String? = null,
    var wikipedia: String? = null,
    var description: String? = null
) : Parcelable
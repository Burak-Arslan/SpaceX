package com.example.spacex.domain.spacexlist.uimodel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RocketImageListUI(
    var image: String? = null
) : Parcelable
package com.example.spacex.ui.homedetail

import com.example.core.ui.DataBindingAdapter
import com.example.spacex.R
import com.example.spacex.domain.spacexlist.uimodel.RocketImageListUI

class AdapterHomeDetail : DataBindingAdapter<RocketImageListUI>() {
    override fun getItemLayoutId(viewType: Int) = R.layout.main_detail_viewpager_item
}

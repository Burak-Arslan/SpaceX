package com.example.spacex.ui.homedetail

import com.example.core.extension.setImageBitmap
import com.example.core.ui.DataBindingAdapter
import com.example.core.ui.DataBindingViewHolder
import com.example.spacex.R
import com.example.spacex.databinding.MainDetailViewpagerItemBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AdapterHomeDetail : DataBindingAdapter<String>() {

    override fun getItemLayoutId(viewType: Int) = R.layout.main_detail_viewpager_item

    override fun onBindViewHolder(holder: DataBindingViewHolder<String>, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = getItem(position)
        GlobalScope.launch {
            (holder.binding as MainDetailViewpagerItemBinding).imgRocketDetail.setImageBitmap(item ?: "")
        }
    }
}

package com.example.spacex.ui.home

import androidx.recyclerview.widget.DiffUtil
import com.example.core.extension.setImageBitmap
import com.example.core.ui.DataBindingAdapter
import com.example.core.ui.DataBindingViewHolder
import com.example.spacex.R
import com.example.spacex.databinding.MainRecyclerItemBinding
import com.example.spacex.domain.spacexlist.uimodel.RocketListUI

class AdapterHome : DataBindingAdapter<RocketListUI>(RocketDiffCallBack()) {

    override fun getItemLayoutId(viewType: Int) = R.layout.main_recycler_item

    override fun onBindViewHolder(holder: DataBindingViewHolder<RocketListUI>, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = getItem(position)
        (holder.binding as MainRecyclerItemBinding).imgRocket.setImageBitmap(item.imageList?.get(0) ?: "")
    }

    class RocketDiffCallBack : DiffUtil.ItemCallback<RocketListUI>() {
        override fun areItemsTheSame(oldItem: RocketListUI, newItem: RocketListUI) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: RocketListUI, newItem: RocketListUI) =
            oldItem == newItem
    }
}

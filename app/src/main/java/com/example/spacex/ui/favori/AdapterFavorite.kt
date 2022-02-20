package com.example.spacex.ui.favori

import coil.load
import com.example.core.ui.DataBindingAdapter
import com.example.core.ui.DataBindingViewHolder
import com.example.spacex.R
import com.example.spacex.data.RocketInfo
import com.example.spacex.databinding.AdapterFavoriteItemBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AdapterFavorite : DataBindingAdapter<RocketInfo>() {
    override fun getItemLayoutId(viewType: Int) = R.layout.adapter_favorite_item

    override fun onBindViewHolder(holder: DataBindingViewHolder<RocketInfo>, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = getItem(position)
        GlobalScope.launch {
            (holder.binding as AdapterFavoriteItemBinding).imgRocket.load(item.imageUrl)
        }
    }
}

package com.example.spacex.ui.home

import androidx.recyclerview.widget.DiffUtil
import coil.load
import com.example.core.ui.DataBindingAdapter
import com.example.core.ui.DataBindingViewHolder
import com.example.spacex.R
import com.example.spacex.data.RocketInfo
import com.example.spacex.databinding.MainRecyclerItemBinding
import com.example.spacex.domain.spacexlist.uimodel.RocketListUI

abstract class AdapterHome : DataBindingAdapter<RocketInfo>(RocketDiffCallBack()) {

    override fun getItemLayoutId(viewType: Int) = R.layout.main_recycler_item

    abstract fun onClickedMore(item: RocketInfo)

    override fun onBindViewHolder(holder: DataBindingViewHolder<RocketInfo>, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = getItem(position)
        (holder.binding as MainRecyclerItemBinding).imgRocket.load(item.imageUrl)
        (holder.binding as MainRecyclerItemBinding).btnFavorite.setOnClickListener {
            onClickedMore(item)
        }
        if(item.isfavorite){
            (holder.binding as MainRecyclerItemBinding).btnFavorite.text = "Çıkar"
        }else{
            (holder.binding as MainRecyclerItemBinding).btnFavorite.text = "Ekle"
        }
    }

    class RocketDiffCallBack : DiffUtil.ItemCallback<RocketInfo>() {
        override fun areItemsTheSame(oldItem: RocketInfo, newItem: RocketInfo) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: RocketInfo, newItem: RocketInfo) =
            oldItem == newItem
    }
}

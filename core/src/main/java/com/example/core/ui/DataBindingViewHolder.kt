package com.example.core.ui

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class DataBindingViewHolder<T>(val binding: ViewDataBinding, private val currentSelected: T? = null) :
    RecyclerView.ViewHolder(binding.root) {

    var viewType: Int = -1

    fun bind(item: T) {
        val itemBR = 1
        binding.setVariable(itemBR, item)
        binding.executePendingBindings()

        itemView.apply {
            currentSelected?.let {
                isActivated = item == currentSelected
            }
        }
    }
}
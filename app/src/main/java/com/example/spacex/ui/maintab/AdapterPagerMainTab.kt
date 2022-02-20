package com.example.spacex.ui.maintab

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.spacex.ui.home.FRHome
import com.example.spacex.ui.favori.FRFavorite

class AdapterPagerMainTab (fa: Fragment): FragmentStateAdapter(fa){

    var items = arrayListOf(FRHome(), FRFavorite())

    override fun getItemCount(): Int = items.size

    override fun createFragment(position: Int) = items[position]
}

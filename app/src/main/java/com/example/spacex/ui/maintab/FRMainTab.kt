package com.example.spacex.ui.maintab

import androidx.viewpager2.widget.ViewPager2
import com.example.core.base.BaseFragment
import com.example.core.extension.injectVM
import com.example.spacex.R
import com.example.spacex.databinding.FrMainTabBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FRMainTab : BaseFragment<FrMainTabBinding>() {

    private val viewModel: FRMainTabVM by injectVM()

    override fun getLayoutId(): Int = R.layout.fr_main_tab

    override fun initViews() {
        vi.vpPager.adapter = AdapterPagerMainTab(this@FRMainTab)

        val tabNames =
            arrayListOf(
               "Roket Listesi",
                "Favori Roketlerim"
            )

        TabLayoutMediator(vi.tabLayout, vi.vpPager) { tab, position ->
            tab.text = tabNames[position]
        }.attach()
    }

    override fun setListener() {
        vi.vpPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {}
        })
    }

    override fun setReceiver() {}

}


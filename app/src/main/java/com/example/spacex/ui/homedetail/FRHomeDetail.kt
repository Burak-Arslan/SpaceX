package com.example.spacex.ui.homedetail

import android.os.Bundle
import android.view.View
import androidx.navigation.navGraphViewModels
import com.example.core.base.BaseFragment
import com.example.core.extension.injectVM
import com.example.core.extension.observe
import com.example.spacex.R
import com.example.spacex.databinding.FrHomeDetailBinding
import com.example.spacex.ui.SharedRocketVM
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FRHomeDetail : BaseFragment<FrHomeDetailBinding>() {

    private val viewModel: FRHomeDetailVM by injectVM()

    private val sharedRocketVM: SharedRocketVM by navGraphViewModels(R.id.FRMainTab)

    lateinit var adapterHomeDetail: AdapterHomeDetail

    override fun getLayoutId() = R.layout.fr_home_detail

    override fun initViews() {}

    override fun setListener() {}

    override fun setReceiver() {}
}
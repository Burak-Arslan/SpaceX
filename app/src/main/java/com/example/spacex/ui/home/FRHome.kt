package com.example.spacex.ui.home

import com.example.core.base.BaseFragment
import com.example.core.extension.injectVM
import com.example.core.extension.observe
import com.example.spacex.R
import com.example.spacex.databinding.FrHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FRHome : BaseFragment<FrHomeBinding>() {

    private val viewModel: FRHomeVM by injectVM()

    override fun getLayoutId() = R.layout.fr_home

    override fun initViews() {
        viewModel.initVM()
    }

    override fun setListener() {}

    override fun setReceiver() {
        observe(viewModel.rocketList) {
            var test = it
            var testtt = ""
        }
    }
}
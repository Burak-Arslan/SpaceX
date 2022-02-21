package com.example.spacex.ui.homedetail

import androidx.navigation.navGraphViewModels
import coil.load
import com.example.core.base.BaseFragment
import com.example.core.extension.injectVM
import com.example.spacex.R
import com.example.spacex.databinding.FrHomeDetailBinding
import com.example.spacex.ui.SharedRocketVM
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FRHomeDetail : BaseFragment<FrHomeDetailBinding>() {

    private val viewModel: FRHomeDetailVM by injectVM()

    private val sharedRocketVM: SharedRocketVM by navGraphViewModels(R.id.FRMainTab)

    override fun getLayoutId() = R.layout.fr_home_detail

    override fun initViews() {
        viewModel.selectedRocketUI = sharedRocketVM.selectedRocketUI
        vi.imgDetailRocket.load(sharedRocketVM.selectedRocketUI?.imageUrl)
        viewModel.setValue()
    }

    override fun setListener() {}

    override fun setReceiver() {}
}
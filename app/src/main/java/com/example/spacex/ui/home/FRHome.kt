package com.example.spacex.ui.home

import androidx.navigation.navGraphViewModels
import com.example.core.base.BaseFragment
import com.example.core.extension.injectVM
import com.example.core.extension.observe
import com.example.spacex.R
import com.example.spacex.databinding.FrHomeBinding
import com.example.spacex.ui.SharedRocketVM
import com.example.spacex.ui.maintab.FRMainTabDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FRHome : BaseFragment<FrHomeBinding>() {

    private val viewModel: FRHomeVM by injectVM()

    private lateinit var adapterHome: AdapterHome

    private val sharedRocketVM: SharedRocketVM by navGraphViewModels(R.id.FRMainTab)

    override fun getLayoutId() = R.layout.fr_home

    override fun initViews() {
        adapterHome = AdapterHome()
        vi.rcyclerMainList.apply {
            adapter = adapterHome
        }
        viewModel.initVM()
    }

    override fun setListener() {
        adapterHome.itemClickListener = {
            sharedRocketVM.selectedRocketUI = it
            navigate(FRMainTabDirections.toFRDetail())
            viewModel.finish()
        }
    }

    override fun setReceiver() {
        observe(viewModel.rocketList) {
            adapterHome.submitList(it)
        }
    }
}
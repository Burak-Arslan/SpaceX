package com.example.spacex.ui.home

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navGraphViewModels
import com.example.core.base.BaseFragment
import com.example.core.extension.injectVM
import com.example.core.extension.observe
import com.example.spacex.R
import com.example.spacex.data.RocketInfo
import com.example.spacex.data.RocketViewModel
import com.example.spacex.databinding.FrHomeBinding
import com.example.spacex.domain.spacexlist.uimodel.RocketListUI
import com.example.spacex.ui.SharedRocketVM
import com.example.spacex.ui.maintab.FRMainTabDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FRHome : BaseFragment<FrHomeBinding>() {

    private val viewModel: FRHomeVM by injectVM()

    private lateinit var adapterHome: AdapterHome

    private lateinit var mRocketViewModel: RocketViewModel

    private val sharedRocketVM: SharedRocketVM by navGraphViewModels(R.id.FRMainTab)

    override fun getLayoutId() = R.layout.fr_home

    override fun initViews() {

        mRocketViewModel = ViewModelProvider(this).get(RocketViewModel::class.java)

        adapterHome = object : AdapterHome() {
            override fun onClickedMore(item: RocketListUI) {
                mRocketViewModel.addRocket(
                    RocketInfo(
                        0,
                        rocketName = item.name ?: "",
                        country = item.country ?: "",
                        company = item.company ?: ""
                    )
                )
            }
        }
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
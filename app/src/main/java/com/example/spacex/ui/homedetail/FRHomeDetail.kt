package com.example.spacex.ui.homedetail

import android.provider.Settings
import androidx.navigation.navGraphViewModels
import coil.load
import com.example.core.base.BaseFragment
import com.example.core.extension.injectVM
import com.example.spacex.R
import com.example.spacex.databinding.FrHomeDetailBinding
import com.example.spacex.ui.SharedRocketVM
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FRHomeDetail : BaseFragment<FrHomeDetailBinding>() {

    val viewModel: FRHomeDetailVM by injectVM()

    private val sharedRocketVM: SharedRocketVM by navGraphViewModels(R.id.FRMainTab)

    override fun getLayoutId() = R.layout.fr_home_detail

    override fun initViews() {
        vi.imgDetailRocket.load(sharedRocketVM.selectedRocketUI?.imageUrl)
        GlobalScope.launch {
            viewModel.setValue(sharedRocketVM.selectedRocketUI)
        }
    }

    override fun setListener() {}

    override fun setReceiver() {}
}
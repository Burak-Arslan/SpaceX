package com.example.spacex.ui.home

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.navigation.navGraphViewModels
import com.example.core.base.BaseFragment
import com.example.core.extension.injectVM
import com.example.core.extension.observe
import com.example.spacex.R
import com.example.spacex.data.RocketInfo
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
        adapterHome = object : AdapterHome() {
            override fun onClickedMore(item: RocketInfo) {
                viewModel.addRocket(item)
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
        }
        vi.swipeRefreshLayout.setOnRefreshListener {
            vi.swipeRefreshLayout.isRefreshing = false
            deleteDialog()
        }
    }

    override fun setReceiver() {
        observe(viewModel.rocketList) {
            adapterHome.submitList(it)
        }
    }

    private fun deleteDialog() {
        val dialogClickListener =
            DialogInterface.OnClickListener { dialog, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        viewModel.allDeleteRocket()
                        dialog.dismiss()
                    }
                    DialogInterface.BUTTON_NEGATIVE -> {
                        dialog.dismiss()
                    }
                }
            }

        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setMessage("Tüm Rocket Kayıtları silinecek emin misin?")
            .setPositiveButton("Evet", dialogClickListener)
            .setNegativeButton("Hayır", dialogClickListener).show()
    }
}
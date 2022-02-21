package com.example.spacex.ui.favori

import com.example.core.base.BaseFragment
import com.example.core.extension.injectVM
import com.example.core.extension.observe
import com.example.spacex.R
import com.example.spacex.databinding.FrFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FRFavorite : BaseFragment<FrFavoriteBinding>() {

    private val viewModel: FRFavoriteVM by injectVM()

    private lateinit var adapterFavorite: AdapterFavorite

    override fun getLayoutId() = R.layout.fr_favorite

    override fun initViews() {
        viewModel.getAllList()
        adapterFavorite = AdapterFavorite()
        vi.rcyclerFavorite.apply { adapter = adapterFavorite }
    }

    override fun setListener() {}

    override fun setReceiver() {
        observe(viewModel.allList) {
            var test = ""
            adapterFavorite.submitList(it)
            var testr = ""
        }
    }
}
package com.example.spacex.ui.favori

import com.example.core.base.BaseFragment
import com.example.core.extension.injectVM
import com.example.spacex.R
import com.example.spacex.databinding.FrFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FRFavorite : BaseFragment<FrFavoriteBinding>() {

    private val viewModel: FRFavoriteVM by injectVM()

    override fun getLayoutId() = R.layout.fr_favorite

    override fun initViews() {
        var test = ""
    }

    override fun setListener() {}

    override fun setReceiver() {}

    override fun onResume() {
        super.onResume()
        var test = ""
    }
}
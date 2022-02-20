package com.example.spacex.ui.splash

import androidx.fragment.app.viewModels
import com.example.core.base.BaseFragment
import com.example.core.extension.isTrue
import com.example.core.extension.observe
import com.example.spacex.R
import com.example.spacex.databinding.FrSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FRSplash : BaseFragment<FrSplashBinding>() {

    private val viewModel: FRSplashVM by viewModels()

    override fun getLayoutId() = R.layout.fr_splash

    override fun initViews() {
        viewModel.initVM()
    }

    override fun setListener() {}

    override fun setReceiver() {
        observe(viewModel.navigationNextValue){
            if(it.isTrue()){
             navigate(FRSplashDirections.toFRMainTab())
            }
        }
    }
}


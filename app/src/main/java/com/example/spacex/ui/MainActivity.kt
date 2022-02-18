package com.example.spacex.ui

import android.os.Bundle
import com.example.core.base.BaseActivity
import com.example.spacex.R
import com.example.spacex.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId() = R.layout.activity_main

    override fun initViews(savedInstanceState: Bundle?) {}

    override fun setListener() {}

    override fun setReceiver() {}
}
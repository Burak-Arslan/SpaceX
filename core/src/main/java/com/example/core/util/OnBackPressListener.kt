package com.example.core.util

interface OnBackPressListener {

    fun isBackEnable():Boolean

    fun onBackPressed():Boolean
}
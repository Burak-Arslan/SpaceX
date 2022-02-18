package com.example.core.base

import android.content.Intent
import androidx.fragment.app.FragmentActivity

abstract class Destination {
    abstract fun getClassName(): Class<out FragmentActivity>
    abstract fun setIntent(intent: Intent)
    var requestCode = -1
    var isSingleTop = false
    var isFinishingAfterStart = false
}

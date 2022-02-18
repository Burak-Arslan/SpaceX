package com.example.core.util

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.Nullable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.example.core.model.ServiceError

interface ViewListener {

    fun showLoading()

    fun hideLoading()

    fun goBack()

    fun showToast(text: String)

    fun showError(error: ServiceError)

    fun navigate(@IdRes resId: Int, @Nullable args: Bundle? = null, navOptions: NavOptions? = null)

    fun navigate(navDirections: NavDirections, navOptions: NavOptions?, navigatorExtras: Navigator.Extras?)

    fun finishActivity()

    fun finishWithResult(result: FinishActivityWithResult)

    fun getNavBackStack(@IdRes navGraphIdRes: Int): NavBackStackEntry?
}
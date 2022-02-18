package com.example.core.util

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.*
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseActivity
import com.example.core.base.BaseFragment
import com.example.core.base.BaseViewModel
import com.example.core.model.ServiceError
import kotlin.reflect.KClass

fun BaseActivity<*>.setViewListener(viewModel: BaseViewModel) {
    viewModel.viewListener = object : ViewListener {
        override fun showLoading() {
            this@setViewListener.showLoading()
        }

        override fun hideLoading() {
            this@setViewListener.hideLoading()
        }

        override fun goBack() {
            this@setViewListener.onBackPressed()
        }

        override fun showToast(text: String) {
            this@setViewListener.showToast(text)
        }

        override fun showError(error: ServiceError) {
            this@setViewListener.showError(error)
        }

        override fun navigate(resId: Int, args: Bundle?, navOptions: NavOptions?) {
        }

        override fun navigate(
            navDirections: NavDirections,
            navOptions: NavOptions?,
            navigatorExtras: Navigator.Extras?
        ) {
        }

        override fun finishActivity() {
            this@setViewListener.finish()
        }

        override fun finishWithResult(result: FinishActivityWithResult) {
            this@setViewListener.setResult(result.resultCode, result.data)
            this@setViewListener.finish()
        }

        override fun getNavBackStack(navGraphIdRes: Int): NavBackStackEntry? {
            return findNavController(R.id.nav_controller_view_tag).getBackStackEntry(navGraphIdRes)
        }
    }
}

fun BaseFragment<*>.setViewListener(viewModel: BaseViewModel) {
    viewModel.viewListener = object : ViewListener {
        override fun showLoading() {
            if (activity != null) {
                (activity as BaseActivity<*>).showLoading()
            }
        }

        override fun hideLoading() {
            if (activity != null) {
                (activity as BaseActivity<*>).hideLoading()
            }
        }

        override fun goBack() {
            activity?.onBackPressed()
        }

        override fun showToast(text: String) {
            if (activity != null) {
                (activity as BaseActivity<*>).showToast(text)
            }
        }

        override fun showError(error: ServiceError) {
            if (activity != null) {
                (activity as BaseActivity<*>).showError(error)
            }
        }

        override fun navigate(resId: Int, args: Bundle?, navOptions: NavOptions?) {
            findNavController().navigate(resId, args, navOptions)
        }

        override fun navigate(navDirections: NavDirections, navOptions: NavOptions?, navigatorExtras: Navigator.Extras?) {
            findNavController().navigate(navDirections.actionId, navDirections.arguments, navOptions, navigatorExtras)
        }

        override fun finishActivity() {
            activity?.finish()
        }

        override fun finishWithResult(result: FinishActivityWithResult) {
            activity?.setResult(result.resultCode, result.data)
            activity?.finish()
        }

        override fun getNavBackStack(navGraphIdRes: Int): NavBackStackEntry? {
            return findNavController().getBackStackEntry((navGraphIdRes))
        }
    }
}

inline fun <reified T : BaseViewModel> Fragment.navGraphViewModels(@IdRes navGraphIdRes: Int? = null): Lazy<T> {
    return viewModels(
        ownerProducer = {
            if (navGraphIdRes == null) {
                findNavController().currentBackStackEntry!!
            } else {
                findNavController().getBackStackEntry(navGraphIdRes)
            }
        },
        factoryProducer = { defaultViewModelProviderFactory }
    )
}

@MainThread
fun <VM : ViewModel> Fragment.navGraphViewModels(clazz: KClass<VM>, @IdRes navGraphIdRes: Int) = lazy {
    val stack = findNavController().getBackStackEntry(navGraphIdRes)

    val factory = stack.defaultViewModelProviderFactory
    val store = stack.viewModelStore

    ViewModelProvider(store, factory).get(clazz.java)
}

@MainThread
fun <VM : ViewModel> BaseViewModel.navGraphViewModels(clazz: KClass<VM>, @IdRes navGraphIdRes: Int) = lazy {
    val stack = viewListener!!.getNavBackStack(navGraphIdRes) ?: throw RuntimeException("Stack element cannot be null")

    val factory = stack.defaultViewModelProviderFactory
    val store = stack.viewModelStore

    ViewModelProvider(store, factory).get(clazz.java)
}

fun Fragment.getParent(): Fragment {
    val parent = requireParentFragment()

    return if (parent is NavHostFragment) {
        parent.getParent()
    } else {
        parent
    }
}
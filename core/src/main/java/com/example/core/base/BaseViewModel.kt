package com.example.core.base

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.Nullable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.example.core.model.ServiceError
import com.example.core.extension.launch
import com.example.core.util.FinishActivityWithResult
import com.example.core.util.NavOption
import com.example.core.util.Tuple3
import com.example.core.util.ViewListener
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow


abstract class BaseViewModel : ViewModel(), LifecycleObserver {

    var tag = this.javaClass.simpleName

    var viewListener: ViewListener? = null
    var navigateDirection =
        MutableSharedFlow<Tuple3<NavDirections, NavOptions?, Navigator.Extras?>>()
    var goBack = MutableSharedFlow<Unit>()
    var finish = MutableSharedFlow<Unit>()
    var navigateDestination = MutableSharedFlow<Destination>()
    var navigateWithId = MutableSharedFlow<Tuple3<Int, Bundle?, NavOptions?>>()
    var popBackStack = MutableSharedFlow<Pair<Int, Boolean>>()


    fun navigate(destination: Destination) = launch {
        navigateDestination.emit(destination)
    }

    fun navigate(
        navDirections: NavDirections,
        navOption: NavOption? = NavOption.ENTER_FROM_RIGHT,
        navigatorExtras: Navigator.Extras? = null
    ) = launch {
        val navOptions = navOption?.let {
            NavOptions.Builder()
                .setEnterAnim(navOption.enter)
                .setExitAnim(navOption.exit)
                .setPopEnterAnim(navOption.popEnter)
                .setPopExitAnim(navOption.popExit)
                .build()
        } ?: run { null }

        navigateDirection.emit(Tuple3(navDirections, navOptions, navigatorExtras))
    }

    fun popBack(@IdRes destinationId: Int, inclusive: Boolean = false) = launch {
        popBackStack.emit(Pair(destinationId, inclusive))
    }

    fun navigate(
        @IdRes resId: Int,
        @Nullable args: Bundle? = null,
        @Nullable navOption: NavOption? = null
    ) {
        viewListener?.navigate(
            resId, args, if (navOption != null) {
                NavOptions.Builder().setEnterAnim(navOption.enter)
                    .setExitAnim(navOption.exit)
                    .setPopEnterAnim(navOption.popEnter)
                    .setPopExitAnim(navOption.popExit)
                    .build()
            } else {
                null
            }
        )
    }

    fun showLoading() {
        viewListener?.showLoading()
    }

    fun hideLoading() {
        viewListener?.hideLoading()
    }


    fun goBack() {
        viewListener?.goBack()
    }

    fun finish() {
        viewListener?.finishActivity()
    }

    fun finishWithResult(result: FinishActivityWithResult) {
        viewListener?.finishWithResult(result)
    }

    fun showError(error: ServiceError) {
        viewListener?.showError(error)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onViewCreated() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    open fun onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    open fun onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun onDestroy() {
    }

    private fun getError(t: Throwable) = when (t) {
        else -> ServiceError.NetworkError
    }

    val exceptionHandler = CoroutineExceptionHandler { _, e ->
        val error = getError(e)
        showError(error)
    }
}
package com.example.core.base

import android.os.Bundle
import android.view.*
import androidx.annotation.LayoutRes
import androidx.annotation.MenuRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController
import com.example.core.extension.clearCurrentFocus
import com.example.core.util.NavOption
import com.example.core.util.OnBackPressListener
import com.example.core.util.ToolbarProperties
import com.example.core.util.setViewListener

abstract class BaseFragment<DB : ViewDataBinding> : Fragment(), OnBackPressListener {

    lateinit var vi: DB
    private var isViewCreated = false

    @LayoutRes
    abstract fun getLayoutId(): Int

    @MenuRes
    open fun getMenuId(): Int = -1

    open fun getViewModels(): List<BaseViewModel>? = null

    abstract fun initViews()
    abstract fun setListener()
    abstract fun setReceiver()
    open fun getToolbarProperties(): ToolbarProperties? = null

    open fun addLifecycleObserver() {
        getViewModels()?.map {
            lifecycle.addObserver(it)
        }
    }

    open fun removeLifecycleObserver() {
        getViewModels()?.map {
            lifecycle.removeObserver(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getViewModels()?.map {
            setViewListener(it)
        }

        addLifecycleObserver()

        setToolbarProperties()
    }

    protected fun navigate(
        navDirections: NavDirections,
        navOption: NavOption? = null,
        navigatorExtras: Navigator.Extras? = null
    ) {
        clearCurrentFocus()
        val navOptions = navOption?.let {
            NavOptions.Builder().setEnterAnim(navOption.enter)
                .setExitAnim(navOption.exit)
                .setPopEnterAnim(navOption.popEnter)
                .setPopExitAnim(navOption.popExit)
                .build()
        } ?: run { null }

        findNavController().navigate(
            navDirections.actionId,
            navDirections.arguments,
            navOptions,
            navigatorExtras
        )
    }

    private fun setToolbarProperties() {
        if (requireActivity() is BaseActivity<*>)
            getToolbarProperties()?.let {
                (requireActivity() as BaseActivity<*>).setToolbarProperties(it)
            }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (!::vi.isInitialized) {
            vi = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
            vi.lifecycleOwner = this
        }

        container?.removeView(vi.root)

        return vi.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        if (!isViewCreated) {
            isViewCreated = true

            initViews()
            setListener()
        }
        setReceiver()
        vi.root.setOnClickListener { clearCurrentFocus() }
    }

    override fun onResume() {
        setToolbarProperties()

        if (requireActivity() is BaseActivity<*> && isBackEnable())
            (requireActivity() as BaseActivity<*>).onBackPressListener = this

        super.onResume()
    }

    override fun onPause() {
        if (requireActivity() is BaseActivity<*> && isBackEnable())
            (requireActivity() as BaseActivity<*>).onBackPressListener = null

        super.onPause()
    }

    override fun onDestroy() {
        removeLifecycleObserver()
        super.onDestroy()
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()

        getMenuId().takeIf {
            it != -1
        }?.let {
            inflater.inflate(it, menu)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }

    override fun isBackEnable() = false
    override fun onBackPressed() = false
}
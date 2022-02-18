package com.example.core.base

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.core.model.ServiceError
import com.example.core.extension.hideKeyboard
import com.example.core.extension.isTrue
import com.example.core.ui.ActivityViewModel
import com.example.core.util.OnBackPressListener
import com.example.core.util.ToolbarProperties
import com.example.core.util.setViewListener

abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity() {

    private val activityViewModel: ActivityViewModel by viewModels()

    lateinit var vi: DB

    @LayoutRes
    abstract fun getLayoutId(): Int

    open fun getViewModels(): List<BaseViewModel>? = null

    abstract fun initViews(savedInstanceState: Bundle?)
    abstract fun setListener()
    abstract fun setReceiver()

    var onBackPressListener: OnBackPressListener? = null

    fun navigate(destination: Destination, startingContext: Fragment? = null) {
        navigateToDestination(destination, startingContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vi = DataBindingUtil.setContentView(this, getLayoutId())

        getViewModels()?.map {
            setViewListener(it)
        }

        vi.lifecycleOwner = this

        initViews(savedInstanceState)
        setListener()
        setReceiver()
    }

    override fun onPause() {
        super.onPause()
        hideKeyboard()
    }

    override fun onBackPressed() {
        if (onBackPressListener?.isBackEnable().isTrue()) {
            if (onBackPressListener?.onBackPressed().isTrue()) {
                super.onBackPressed()
            }
        } else {
            super.onBackPressed()
        }
    }

    override fun onResume() {
        super.onResume()
        restartActivityIfNeeded()
    }

    fun showLoading() {
        //TODO dolduruılacak
    }

    fun hideLoading() {
        //TODO dolduruılacak
    }

    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun showError(error: ServiceError) {
        //TODO servis error kısımları yazılacak
    }

    fun findNavHostFragment(navHostId: Int) = supportFragmentManager.findFragmentById(navHostId) as NavHostFragment?

    open fun setToolbarProperties(properties: ToolbarProperties) {
    }

    fun reCreateActivity(intent: Intent) {
        finish()
        startActivity(intent)
        overridePendingTransition(0, 0)
    }

    private fun restartActivityIfNeeded() {
        if (activityViewModel.loadedLanguage != activityViewModel.language)
            reCreateActivity(intent)
    }
}
package com.example.core.base

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.core.base.BaseActivity

internal fun BaseActivity<*>.navigateToDestination(
    destination: Destination,
    startingContext: Fragment? = null
) :Destination{

    Intent(this, destination.getClassName()).apply {
        try {

            destination.setIntent(this)

            if (destination.requestCode != -1) {
                startingContext?.startActivityForResult(this, destination.requestCode) ?: startActivityForResult(
                    this,
                    destination.requestCode
                )
            } else {
                if (destination.isSingleTop) {
                    this.clearStack()
                }
                startingContext?.startActivity(this) ?: startActivity(this)

                if (destination.isFinishingAfterStart or destination.isSingleTop) {
                    finish()
                }
            }
        } catch (e: ActivityNotFoundException) {
            // Write log
        }
    }
    return destination
}

fun Intent.clearStack() {
    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
}

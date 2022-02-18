package com.example.core.base

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.FragmentActivity

open class BaseApp : Application() {

    lateinit var currentActivity: FragmentActivity

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                currentActivity = activity as FragmentActivity
            }

            override fun onActivityStarted(activity: Activity) {
                currentActivity = activity as FragmentActivity
            }

            override fun onActivityResumed(activity: Activity) {
                currentActivity = activity as FragmentActivity
            }

            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityDestroyed(activity: Activity) {
            }
        })
    }
}
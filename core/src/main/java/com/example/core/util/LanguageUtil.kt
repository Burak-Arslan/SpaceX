package com.example.core.util

import android.annotation.TargetApi
import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.util.DisplayMetrics
import com.example.core.base.constants.DEFAULT_LANG
import com.example.core.base.constants.LANG
import com.example.core.base.constants.PREF_NAME
import com.example.core.ui.ActivityViewModel
import java.util.*

object LanguageUtil {

    fun getLanguage(context: Context): String {
        val preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return preferences.getString(LANG, DEFAULT_LANG) ?: DEFAULT_LANG
    }

    fun init(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        updateLanguage(context, locale)
    }

    fun switchLanguage(context: Context, activityViewModel: ActivityViewModel) {
        val locale = Locale(activityViewModel.getReverseCurrentLanguage())
        Locale.setDefault(locale)

        updateLanguage(context, locale)

        activityViewModel.toggleLanguage()
    }

    private fun updateLanguage(context: Context, locale: Locale) {
        val configuration = context.resources.configuration
        val res: Resources = context.resources
        val dm: DisplayMetrics = res.displayMetrics

        configuration.setLocale(locale)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context.applicationContext.createConfigurationContext(configuration)
        } else {
            @Suppress("DEPRECATION")
            res.updateConfiguration(configuration, dm)
        }
    }

    fun updateBaseContextLocale(context: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            updateResources(context, locale)
        } else updateResourcesLegacy(context, locale)
    }

    @TargetApi(Build.VERSION_CODES.N)
    private fun updateResources(context: Context, locale: Locale): Context {

        val configuration = context.resources.configuration
        configuration.setLocale(locale)
        configuration.setLayoutDirection(locale)

        return context.createConfigurationContext(configuration)
    }

    @Suppress("DEPRECATION")
    private fun updateResourcesLegacy(context: Context, locale: Locale): Context {
        val resources = context.resources
        val configuration = resources.configuration
        configuration.locale = locale
        configuration.setLayoutDirection(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)

        return context
    }
}

package com.example.core.base.constants

import android.content.Context
import androidx.annotation.VisibleForTesting
import com.example.core.model.AppConfig
import com.example.core.extension.put
import com.google.gson.Gson

const val PREF_NAME = "pref"

const val DEFAULT_LANG = "tr"
const val LANG = "lang"
const val LAST_VERSION = "last_version"

class PreferenceWrapper(context: Context, private val gson: Gson, private val appConfig: AppConfig) {

    @VisibleForTesting
    private val preferences by lazy { context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE) }

    var language: String
        get() {
            return preferences.getString(LANG, DEFAULT_LANG)
                ?: DEFAULT_LANG
        }
        set(value) {
            preferences.put(LANG, value)
        }

    fun isNewVersion(): Boolean {
        val lastVersion = preferences.getString(LAST_VERSION, "") ?: ""

        if (lastVersion != appConfig.version) {
            return true
        }

        return false
    }

    fun refreshCurrentVersion() {
        setLastVersion(appConfig.version)
    }

    fun setLastVersion(version: String) {
        preferences.put(LAST_VERSION, version)
    }
}
package com.example.core.base.constants

interface CommonPreferences {
    fun getLang(): String
    fun setLang(newLang: String)
    fun isNewVersion(): Boolean
    fun refreshCurrentVersion()
}

class CommonPreferencesImpl(private val pref: PreferenceWrapper) : CommonPreferences {

    override fun getLang() = pref.language

    override fun setLang(newLang: String) {
        pref.language = newLang
    }

    override fun isNewVersion() = pref.isNewVersion()

    override fun refreshCurrentVersion() = pref.refreshCurrentVersion()
}

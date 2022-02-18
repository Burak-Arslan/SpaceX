package com.example.core.ui

import com.example.core.base.BaseViewModel
import com.example.core.base.constants.CommonPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel @Inject constructor(private val pref: CommonPreferences) : BaseViewModel() {

    val loadedLanguage = pref.getLang()

    val language: String
        get() = pref.getLang()

    fun toggleLanguage() {
        if (pref.getLang() == "en") {
            pref.setLang("tr")
        } else {
            pref.setLang("en")
        }
    }

    fun getReverseCurrentLanguage() = if (isTurkish()) {
        "en"
    } else {
        "tr"
    }

    fun isTurkish(): Boolean = language == "tr"
    fun isEnglish(): Boolean = language == "en"
}

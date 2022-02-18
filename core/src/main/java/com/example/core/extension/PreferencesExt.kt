package com.example.core.extension

import android.content.SharedPreferences

fun SharedPreferences.put(key: String, v: String) {
    edit().putString(key, v).apply()
}

fun SharedPreferences.putLong(key: String, v: Long) {
    edit().putLong(key, v).apply()
}

fun SharedPreferences.putBoolean(key: String, v: Boolean) {
    edit().putBoolean(key, v).apply()
}

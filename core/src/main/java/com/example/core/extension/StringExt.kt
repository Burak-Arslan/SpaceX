package com.example.core.extension;

import com.example.core.util.GsonProvider
import com.google.gson.reflect.TypeToken

inline fun <reified T> String.toModel(): T = GsonProvider.gson.fromJson(this, object : TypeToken<T>() {}.type)

package com.example.core.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder

object GsonProvider {
    var gson: Gson = GsonBuilder().create()
}
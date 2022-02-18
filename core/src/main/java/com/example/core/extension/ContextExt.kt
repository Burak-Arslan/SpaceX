package com.example.core.extension

import android.content.Context
import java.io.InputStream

inline fun <reified T> Context.getJson(file: Int): T {
    val input: InputStream = resources.openRawResource(file)

    val b = ByteArray(input.available())
    input.read(b)

    return String(b).toModel()
}
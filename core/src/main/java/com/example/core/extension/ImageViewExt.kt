package com.example.core.extension

import android.graphics.BitmapFactory
import android.widget.ImageView
import java.io.IOException
import java.io.InputStream
import java.net.MalformedURLException
import java.net.URL

fun ImageView.setImageBitmap(url: String) {
    val thread = Thread {
        try {
            if (url?.isNotEmpty() == true) {
                try {
                    val bitmap = BitmapFactory.decodeStream(URL(url).content as InputStream)
                    this.setImageBitmap(bitmap)
                } catch (e: MalformedURLException) {
                    e.printStackTrace()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
    thread.start()
}
package com.example.core.util

import android.text.method.PasswordTransformationMethod
import android.view.View

class PasswordTransformation(private val maskChar: Char = '*') : PasswordTransformationMethod() {

    override fun getTransformation(source: CharSequence, view: View?)
            : CharSequence = PasswordCharSequence(source, maskChar)

    private class PasswordCharSequence(val source: CharSequence, val maskChar: Char) :
        CharSequence {

        override val length: Int
            get() = source.length

        override fun get(index: Int) = maskChar

        override fun subSequence(startIndex: Int, endIndex: Int) =
            source.subSequence(startIndex, endIndex)
    }
}

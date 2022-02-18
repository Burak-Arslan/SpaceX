package com.example.core.extension

import androidx.fragment.app.Fragment
import com.example.core.extension.hideKeyboard

fun Fragment.clearCurrentFocus() {
    requireActivity().currentFocus?.clearFocus()
    requireActivity().hideKeyboard()
}
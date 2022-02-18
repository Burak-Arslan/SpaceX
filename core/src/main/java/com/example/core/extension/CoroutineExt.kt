package com.example.core.extension

import androidx.lifecycle.viewModelScope
import com.example.core.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun BaseViewModel.launch(block: suspend CoroutineScope.() -> Unit): Job {
    return viewModelScope.launch(exceptionHandler, CoroutineStart.DEFAULT, block)
}
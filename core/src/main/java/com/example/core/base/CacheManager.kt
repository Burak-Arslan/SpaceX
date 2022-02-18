package com.example.core.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

open class CacheManager @Inject constructor() {

    private val _cacheEntryFlow = MutableSharedFlow<CachedEntry<*>>()

    fun getCacheEntryListener(): Flow<CachedEntry<*>> {
        return _cacheEntryFlow.asSharedFlow()
    }

    suspend fun cacheEntry(entry: CachedEntry<*>) {
        _cacheEntryFlow.emit(entry)
    }
}

data class CachedEntry<T>(
    val value: T? = null,
    val tag: String? = null
)
package com.example.core.util

enum class MenuType(val type: Int) {
    NONE(0),
    BACK(1),
    CLOSE(2);

    companion object {
        fun getLeftIcon(styleType: Int) = values().first { it.type == styleType }
    }
}
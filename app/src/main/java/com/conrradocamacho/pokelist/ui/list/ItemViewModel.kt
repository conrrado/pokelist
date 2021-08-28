package com.conrradocamacho.pokelist.ui.list

import androidx.annotation.LayoutRes

interface ItemViewModel {
    @get:LayoutRes
    val layoutId: Int
    val viewType: Int
        get() = 0
}

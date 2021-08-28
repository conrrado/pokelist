package com.conrradocamacho.pokelist.ui.list.itemviewmodels

import com.conrradocamacho.pokelist.R
import com.conrradocamacho.pokelist.ui.list.ItemViewModel
import com.conrradocamacho.pokelist.ui.list.PokeListViewModel
import com.conrradocamacho.pokelist.utils.PokeType

class HeaderViewModel(val pokeType: PokeType) : ItemViewModel {
    override val layoutId: Int = R.layout.item_header
    override val viewType: Int = PokeListViewModel.HEADER_ITEM
}

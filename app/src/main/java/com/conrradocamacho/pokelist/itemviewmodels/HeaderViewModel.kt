package com.conrradocamacho.pokelist.itemviewmodels

import com.conrradocamacho.pokelist.ItemViewModel
import com.conrradocamacho.pokelist.PokeListViewModel
import com.conrradocamacho.pokelist.PokeType
import com.conrradocamacho.pokelist.R

class HeaderViewModel(val pokeType: PokeType) : ItemViewModel {
    override val layoutId: Int = R.layout.item_header
    override val viewType: Int = PokeListViewModel.HEADER_ITEM
}

package com.conrradocamacho.pokelist.ui.list.itemviewmodels

import com.conrradocamacho.pokelist.ui.list.PokeListViewModel
import com.conrradocamacho.pokelist.utils.PokeType
import com.conrradocamacho.pokelist.R
import com.conrradocamacho.pokelist.ui.list.ItemViewModel

class PokeAdViewModel(val pokeType: PokeType, val name: String, val url: String) : ItemViewModel {
    override val layoutId: Int = R.layout.item_poke_listing_ad
    override val viewType: Int = PokeListViewModel.AD_ITEM
}
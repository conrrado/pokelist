package com.conrradocamacho.pokelist.itemviewmodels

import com.conrradocamacho.pokelist.ItemViewModel
import com.conrradocamacho.pokelist.PokeListViewModel
import com.conrradocamacho.pokelist.PokeType
import com.conrradocamacho.pokelist.R

class PokeAdViewModel(val pokeType: PokeType, val name: String, val url: String) : ItemViewModel {
    override val layoutId: Int = R.layout.item_poke_listing_ad
    override val viewType: Int = PokeListViewModel.AD_ITEM
}

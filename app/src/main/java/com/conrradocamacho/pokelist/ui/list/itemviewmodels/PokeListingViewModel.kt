package com.conrradocamacho.pokelist.ui.list.itemviewmodels

import com.conrradocamacho.pokelist.R
import com.conrradocamacho.pokelist.ui.list.ItemViewModel
import com.conrradocamacho.pokelist.ui.list.PokeListViewModel

class PokeListingViewModel(val typeName: String, val name: String, val url: String) :
    ItemViewModel {
    override val layoutId: Int = R.layout.item_poke_listing
    override val viewType: Int = PokeListViewModel.LISTING_ITEM
}

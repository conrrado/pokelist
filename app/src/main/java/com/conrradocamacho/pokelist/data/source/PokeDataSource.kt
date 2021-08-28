package com.conrradocamacho.pokelist.data.source

import com.conrradocamacho.pokelist.data.model.PokeData

interface PokeDataSource {

    fun getPokeListData(): List<PokeData>
}
package com.conrradocamacho.pokelist.data.source

import com.conrradocamacho.pokelist.data.model.PokeData

interface PokeDataSource {

    suspend fun getPokeListData(type: Int): List<PokeData>
}
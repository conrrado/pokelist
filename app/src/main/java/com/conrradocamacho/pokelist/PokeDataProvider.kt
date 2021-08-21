package com.conrradocamacho.pokelist

interface PokeDataProvider {

    fun getPokeListData(): List<PokeData>
}
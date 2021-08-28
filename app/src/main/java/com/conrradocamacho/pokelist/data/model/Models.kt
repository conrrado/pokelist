package com.conrradocamacho.pokelist.data.model

import com.google.gson.annotations.SerializedName

data class PokemonType(
    @SerializedName("pokemon")
    val list: List<Pokemon>?
    )

data class Pokemon (val pokemon: PokemonDetail)

data class PokemonDetail(val name: String, val url: String)

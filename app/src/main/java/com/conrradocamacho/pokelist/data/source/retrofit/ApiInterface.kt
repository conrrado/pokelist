package com.conrradocamacho.pokelist.data.source.retrofit

import com.conrradocamacho.pokelist.data.model.PokemonType
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("type/{id}")
    suspend fun getByTypeId(@Path("id") typeId: Int): PokemonType
}
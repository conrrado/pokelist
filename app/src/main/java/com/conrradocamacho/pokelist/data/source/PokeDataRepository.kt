package com.conrradocamacho.pokelist.data.source

import com.conrradocamacho.pokelist.data.model.PokeData
import com.conrradocamacho.pokelist.data.model.PokemonType
import com.conrradocamacho.pokelist.data.source.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokeDataRepository private constructor() : PokeDataSource {

    companion object {
        private var INSTANCE: PokeDataRepository? = null
        fun getInstance() : PokeDataRepository {
            if (INSTANCE == null) {
                INSTANCE = PokeDataRepository()
            }
            return INSTANCE!!
        }
    }

    override suspend fun getPokeListData(type: Int): List<PokeData> {
        return withContext(Dispatchers.IO) {
            val list = RetrofitClient.apiInterface.getByType(type)
            converterToPokeDataList(list, type)
        }
    }

    private fun converterToPokeDataList(pokemonType: PokemonType?, type: Int): List<PokeData> {
        if (pokemonType?.list == null) {
            return emptyList()
        }

        val pokeDataList: MutableList<PokeData> = mutableListOf()
        for (item in pokemonType.list) {
            pokeDataList.add(PokeData(type, item.pokemon.name, item.pokemon.url, false))
        }
        return pokeDataList
    }
}
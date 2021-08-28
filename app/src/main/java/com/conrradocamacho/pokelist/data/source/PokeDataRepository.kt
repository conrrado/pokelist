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

    override suspend fun getPokeListData(): List<PokeData> {

        // todo: verificar se banco de dados tem valor se não tiver fazer a chamada da web caso contrario pegar do banco de dados

        val numberOfPokemonTypes = 18

        return withContext(Dispatchers.IO) {
            val list: MutableList<PokeData> = mutableListOf()
            for (i in 1..numberOfPokemonTypes) {
                val aux = RetrofitClient.apiInterface.getByTypeId(i)
                val convertedList = converterToPokeDataList(aux, i)
                list.addAll(convertedList)
            }
            list
        }
    }

    private fun converterToPokeDataList(pokemonType: PokemonType?, type: Int): List<PokeData> {
        if (pokemonType?.list == null) {
            return emptyList()
        }

        var firstItem = true

        val pokeDataList: MutableList<PokeData> = mutableListOf()
        for (item in pokemonType.list) {
            pokeDataList.add(PokeData(pokemonType.nameType, item.pokemon.name, item.pokemon.url, firstItem))
            firstItem = false
        }
        return pokeDataList
    }
}
package com.conrradocamacho.pokelist.data.source

import com.conrradocamacho.pokelist.data.model.PokeData

class PokeDataRepository private constructor(
    private val localDataSource: PokeDataSource,
    private val remoteDataSource: PokeDataSource
) : PokeDataSource {

    companion object {
        private var INSTANCE: PokeDataRepository? = null
        fun getInstance(localDataSource: PokeDataSource, remoteDataSource: PokeDataSource) : PokeDataRepository {
            if (INSTANCE == null) {
                INSTANCE = PokeDataRepository(localDataSource, remoteDataSource)
            }
            return INSTANCE!!
        }
    }

    override fun getPokeListData(): List<PokeData> {
        if (isInternet()) {
            return remoteDataSource.getPokeListData()
        }
        return localDataSource.getPokeListData()
    }

    fun isInternet() = false
}
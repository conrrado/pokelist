package com.conrradocamacho.pokelist.data.source.remote

import com.conrradocamacho.pokelist.data.model.PokeData
import com.conrradocamacho.pokelist.data.source.PokeDataSource

class RemoteDataSource : PokeDataSource {

    companion object {
        private var INSTANCE: RemoteDataSource? = null
        fun getInstance() : RemoteDataSource {
            if (INSTANCE == null) {
                INSTANCE = RemoteDataSource()
            }
            return INSTANCE!!
        }
    }
    override fun getPokeListData(): List<PokeData> {
        TODO("Not yet implemented")
    }
}
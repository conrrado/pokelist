package com.conrradocamacho.pokelist

import com.conrradocamacho.pokelist.data.source.PokeDataRepository
import com.conrradocamacho.pokelist.data.source.PokeDataSource
import com.conrradocamacho.pokelist.data.source.local.LocalDataSource
import com.conrradocamacho.pokelist.data.source.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun providePokeDataProvider(): PokeDataRepository {
        return PokeDataRepository.getInstance(
            LocalDataSource.getInstance(),
            RemoteDataSource.getInstance())
    }
}
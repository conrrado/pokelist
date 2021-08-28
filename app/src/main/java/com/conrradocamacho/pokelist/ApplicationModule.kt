package com.conrradocamacho.pokelist

import com.conrradocamacho.pokelist.data.source.PokeDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun providePokeDataRepository(): PokeDataRepository {
        return PokeDataRepository.getInstance()
    }
}
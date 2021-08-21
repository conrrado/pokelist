package com.conrradocamacho.pokelist

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun providePokeDataProvider(): PokeDataProvider {
        return PokeDataMock()
    }
}
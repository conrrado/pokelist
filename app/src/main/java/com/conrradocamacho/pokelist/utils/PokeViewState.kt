package com.conrradocamacho.pokelist.utils

sealed class PokeViewState {

    object Loading : PokeViewState()

    object Success : PokeViewState()

}

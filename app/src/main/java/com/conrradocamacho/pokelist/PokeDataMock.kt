package com.conrradocamacho.pokelist

class PokeDataMock : PokeDataProvider {
    override fun getPokeListData(): List<PokeData> {
        return listOf(
            PokeData(1, "pidgey", "https://pokeapi.co/api/v2/pokemon/16/", false),
            PokeData(1, "rattata", "https://pokeapi.co/api/v2/pokemon/19/", false),
            PokeData(2, "mankey", "https://pokeapi.co/api/v2/pokemon/56/", false),
            PokeData(2, "primeape", "https://pokeapi.co/api/v2/pokemon/57/", false),
            PokeData(2, "poliwrath", "https://pokeapi.co/api/v2/pokemon/62/", false),
            PokeData(2, "combusken", "https://pokeapi.co/api/v2/pokemon/256/", false),
            PokeData(3, "butterfree", "https://pokeapi.co/api/v2/pokemon/12/", false),
            PokeData(3, "charizard", "https://pokeapi.co/api/v2/pokemon/6/", true),
            PokeData(3, "scyther", "https://pokeapi.co/api/v2/pokemon/123/", false),
            PokeData(4, "weedle", "https://pokeapi.co/api/v2/pokemon/13/", false)
        )
    }
}
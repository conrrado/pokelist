package com.conrradocamacho.pokelist.utils

enum class PokeType(val type: Int, val title: String) {
    NORMAL(1, "Normal"),
    FIGHTING(2, "Fighting"),
    FLYING(3, "Flying"),
    POISON(4, "Poison");

    companion object {
        fun getByType(type: Int): PokeType {
            for (item in values()) {
                if (type == item.type) {
                    return item
                }
            }
            return NORMAL
        }
    }
}
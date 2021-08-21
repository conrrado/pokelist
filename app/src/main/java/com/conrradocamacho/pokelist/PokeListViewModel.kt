package com.conrradocamacho.pokelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.conrradocamacho.pokelist.itemviewmodels.HeaderViewModel
import com.conrradocamacho.pokelist.itemviewmodels.PokeAdViewModel
import com.conrradocamacho.pokelist.itemviewmodels.PokeListingViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokeListViewModel @Inject constructor(
    private val pokeDataProvider: PokeDataProvider
) : ViewModel() {

    val data: LiveData<List<ItemViewModel>>
        get() = _data
    private val _data = MutableLiveData<List<ItemViewModel>>(emptyList())

    init {
        loadData()
    }

    private fun loadData() {
        // This is a coroutine scope with the lifecycle of the viewmodel
        viewModelScope.launch {
            // getPokeListData() is a suspend function
            val pokeList = pokeDataProvider.getPokeListData()

            val pokesByType = pokeList.groupBy { it.type }

            val viewData = createViewData(pokesByType)
            _data.postValue(viewData)
        }
    }

    private fun createViewData(pokesByType: Map<Int, List<PokeData>>): List<ItemViewModel> {
        val viewData = mutableListOf<ItemViewModel>()
        pokesByType.keys.forEach {
            val pokeType = PokeType.getByType(it)
            viewData.add(HeaderViewModel(pokeType))
            val pokes = pokesByType[it]
            pokes?.forEach { poke: PokeData ->
                val item = if (poke.isAd) {
                    PokeAdViewModel(pokeType, poke.name, poke.url)
                } else {
                    PokeListingViewModel(pokeType, poke.name, poke.url)
                }
                viewData.add(item)
            }
        }
        return viewData
    }

    companion object {
        const val HEADER_ITEM = 0
        const val LISTING_ITEM = 1
        const val AD_ITEM = 2
    }
}
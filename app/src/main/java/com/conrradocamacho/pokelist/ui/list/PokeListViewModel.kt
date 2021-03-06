package com.conrradocamacho.pokelist.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.conrradocamacho.pokelist.data.model.PokeData
import com.conrradocamacho.pokelist.data.source.PokeDataRepository
import com.conrradocamacho.pokelist.ui.list.itemviewmodels.HeaderViewModel
import com.conrradocamacho.pokelist.ui.list.itemviewmodels.PokeAdViewModel
import com.conrradocamacho.pokelist.ui.list.itemviewmodels.PokeListingViewModel
import com.conrradocamacho.pokelist.utils.PokeViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokeListViewModel @Inject constructor(
    private val pokeDataRepository: PokeDataRepository
) : ViewModel() {

    private val _data = MutableLiveData<List<ItemViewModel>>(emptyList())
    val data: LiveData<List<ItemViewModel>>
        get() = _data

    private val _state: MutableLiveData<PokeViewState> = MutableLiveData()
    val state: LiveData<PokeViewState>
        get() = _state

    init {
        loadData()
    }

    private fun loadData() {
        // This is a coroutine scope with the lifecycle of the viewmodel
        viewModelScope.launch {
            _state.value = PokeViewState.Loading
            var pokeList = emptyList<PokeData>()

            try {
                // getPokeListData() is a suspend function
                pokeList = pokeDataRepository.getPokeListData()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            _state.value = PokeViewState.Success

            val pokesByType = pokeList.groupBy { it.type }

            val viewData = createViewData(pokesByType)
            _data.postValue(viewData)
        }
    }

    private fun createViewData(pokesByType: Map<String, List<PokeData>>?): List<ItemViewModel> {
        val viewData = mutableListOf<ItemViewModel>()
        pokesByType?.keys?.forEach {
            viewData.add(HeaderViewModel(it))
            val pokes = pokesByType[it]
            pokes?.forEach { poke: PokeData ->
                val item = if (poke.isAd) {
                    PokeAdViewModel(it, poke.name, poke.url)
                } else {
                    PokeListingViewModel(it, poke.name, poke.url)
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
package com.example.gameinformation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.gameinformation.common.Resource
import com.example.gameinformation.features.home.domain.entity.GamesUi
import com.example.gameinformation.features.home.domain.usecase.GamesUseCase
import com.example.gameinformation.features.stores.domain.entity.StoreUIModel
import com.example.gameinformation.features.stores.domain.usecase.StoreUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val gamesUseCase: GamesUseCase,
    private val storeUseCase: StoreUseCase
) : ViewModel() {
    private var _state = MutableStateFlow<PagingData<GamesUi>>(PagingData.empty())
    val gameState = _state.asStateFlow()
    private var _store = MutableStateFlow<List<StoreUIModel>>(emptyList())
    val storeState = _store.asStateFlow()

    init {
        getGames()
        getStore()
    }


    private fun getGames() = viewModelScope.launch {
        gamesUseCase(5).cachedIn(viewModelScope).collect { result ->


            _state.value = result





        }

    }

    private fun getStore() = viewModelScope.launch {
        storeUseCase().collect{result->
            when(result){
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    _store.value = result.data
            }
                is Resource.Error -> {

                }
            }

        }

    }
}


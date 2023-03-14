package com.example.gameinformation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameinformation.common.Resource
import com.example.gameinformation.features.home.domain.entity.GamesUi
import com.example.gameinformation.features.home.domain.usecase.GamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val gamesUseCase: GamesUseCase
) : ViewModel() {
    private var _state = MutableStateFlow<List<GamesUi>>(emptyList())
    val homestate = _state.asStateFlow()

    init {
        getGames()
    }

    private fun getGames() = viewModelScope.launch {
        gamesUseCase().collect { result ->
            when (result) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    _state.value = result.data


                }
                is Resource.Error -> {

                }
            }


        }

    }
}


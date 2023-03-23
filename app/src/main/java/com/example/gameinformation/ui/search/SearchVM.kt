package com.example.gameinformation.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.gameinformation.features.home.domain.entity.GamesUi
import com.example.gameinformation.features.home.domain.usecase.LastSearchedWordsUseCase
import com.example.gameinformation.features.home.domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SearchVM @Inject constructor(
    private val searchUseCase: SearchUseCase,
    private val lastSearchedWordsUseCase: LastSearchedWordsUseCase,

    ) : ViewModel() {
    private var _searchGame = MutableStateFlow<PagingData<GamesUi>>(PagingData.empty())
    var searchGame = _searchGame.asStateFlow()

    private var _lastSearchedWords= MutableStateFlow<List<String>> (emptyList())
    var lastSearchedWordsState = _lastSearchedWords.asStateFlow()

    init {
        //astSearchedWords()


    }

//    fun lastSearchedWords() = viewModelScope.launch {
//        lastSearchedWordsUseCase().collect { result ->
//            _lastSearchedWords.value = result
//
//        }
//    }
    fun searchGame(query:String) = viewModelScope.launch {
    searchUseCase(20, query).cachedIn(viewModelScope).collect { result ->
        _searchGame.value = result
    }
}
 // }
}
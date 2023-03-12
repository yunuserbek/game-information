package com.example.gameinformation.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameinformation.common.Resource
import com.example.gameinformation.features.detail.domain.entity.DetailUiModel
import com.example.gameinformation.features.detail.domain.usecase.DetailUseCase
import com.example.gameinformation.features.home.domain.entity.GamesUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class DetailVM @Inject constructor(
    private val detailUseCase: DetailUseCase
):ViewModel(){
    private var _state = MutableStateFlow<Resource<DetailUiModel>>(Resource.Loading)
    val detailState = _state.asSharedFlow()


   fun getDetail(id:Int) = viewModelScope.launch {
       detailUseCase(id).collect{
           _state.value =it
       }
   }
}
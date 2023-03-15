package com.example.gameinformation.ui.storedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameinformation.common.Resource
import com.example.gameinformation.features.stores.domain.usecase.StoreUseCase
import com.example.gameinformation.features.storesdetail.domain.entity.StoresDetailUiModel
import com.example.gameinformation.features.storesdetail.domain.mapper.toStoresMapper
import com.example.gameinformation.features.storesdetail.domain.usecase.StoresDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoresVM @Inject constructor(
    private val storeDetailUseCase: StoresDetailUseCase,
    savedStateHandle: SavedStateHandle

    ):ViewModel(){

    private val _storesData =MutableSharedFlow<StoresDetailUiModel>()
    val storesData = _storesData.asSharedFlow()


    init {
        savedStateHandle.get<Int>("storeid")?.let {
            getStores(it)
        }
    }


     fun getStores(id:Int)=viewModelScope.launch {

        storeDetailUseCase(id).collect{result->
            when(result){
                is Resource.Loading->{

                }
                is Resource.Success->{

                    _storesData.emit(result.data)
                }
                is Resource.Error->{

                }

            }

        }
    }




}
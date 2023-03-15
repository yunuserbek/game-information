package com.example.gameinformation.features.storesdetail.domain.repository

import com.example.gameinformation.common.Resource
import com.example.gameinformation.features.stores.domain.entity.StoreUIModel
import com.example.gameinformation.features.storesdetail.data.model.StoresDetailResponse
import com.example.gameinformation.features.storesdetail.domain.entity.StoresDetailUiModel
import kotlinx.coroutines.flow.Flow


interface StoresDetailRepository {
    suspend fun getStoresDetail(id:Int): Flow<Resource<StoresDetailUiModel>>
}
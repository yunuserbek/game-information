package com.example.gameinformation.features.stores.domain.repository

import kotlinx.coroutines.flow.Flow
import com.example.gameinformation.common.Resource
import com.example.gameinformation.features.stores.data.model.StoreResponse
import com.example.gameinformation.features.stores.domain.entity.StoreUIModel

interface StoreRepository {

    suspend fun getStores():Flow<Resource<List<StoreUIModel>>>
}
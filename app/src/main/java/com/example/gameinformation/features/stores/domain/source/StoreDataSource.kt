package com.example.gameinformation.features.stores.domain.source

import com.example.gameinformation.features.stores.data.model.StoreResponse

interface StoreDataSource {
    suspend fun getStores(): StoreResponse
}
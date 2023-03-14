package com.example.gameinformation.features.stores.data.source

import com.example.gameinformation.features.stores.data.api.StoresService
import com.example.gameinformation.features.stores.data.model.StoreResponse
import com.example.gameinformation.features.stores.domain.source.StoreDataSource

class StoreDataSourceImpl(private var storesService: StoresService) : StoreDataSource {
    override suspend fun getStores(): StoreResponse {

        return storesService.getStores()
    }
}
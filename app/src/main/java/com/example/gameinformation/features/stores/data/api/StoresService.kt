package com.example.gameinformation.features.stores.data.api

import com.example.gameinformation.features.stores.data.model.StoreResponse
import retrofit2.http.GET

interface StoresService {
    @GET("stores")
    suspend fun getStores(): StoreResponse
}
package com.example.gameinformation.features.stores.data.api

import com.example.gameinformation.features.stores.data.model.StoreResponse
import com.example.gameinformation.utilty.constants.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface StoresService {
    @GET("stores")
    suspend fun getStores(@Query("key")key:String =Constants.TOKEN
    ): StoreResponse
}
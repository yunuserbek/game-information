package com.example.gameinformation.features.storesdetail.data.api

import com.example.gameinformation.features.storesdetail.data.model.StoresDetailResponse
import com.example.gameinformation.utilty.constants.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StoresDetailService {
    @GET("stores/{id}")
    suspend fun getStoresDetail(@Path("id")id:Int,@Query("key")key:String =Constants.TOKEN):StoresDetailResponse
}
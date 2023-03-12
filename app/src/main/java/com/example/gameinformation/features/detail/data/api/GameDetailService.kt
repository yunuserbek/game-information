package com.example.gameinformation.features.detail.data.api

import com.example.gameinformation.features.detail.data.model.DetailResponse
import com.example.gameinformation.features.home.data.model.GameResponse
import com.example.gameinformation.utilty.constants.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameDetailService {
    @GET("games/{id}")
    suspend fun gameDetail(@Path("id") id: Int, @Query("key") key: String = Constants.TOKEN): DetailResponse
}

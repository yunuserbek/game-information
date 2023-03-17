package com.example.gameinformation.features.home.data.api

import com.example.gameinformation.features.home.data.model.GamesResponse
import com.example.gameinformation.utilty.constants.Constants.TOKEN
import retrofit2.http.GET
import retrofit2.http.Query

interface GameService {
    @GET("games")
    suspend fun games(
        @Query("key") key: String = TOKEN,
        @Query("page") page: Int,
        @Query("page_size") page_size: Int,
        @Query("search") query: String?= null,
    ): GamesResponse

//@GET("games")
//    suspend fun searchGames(
//        @Query("key") key: String = TOKEN,
//        @Query("page") page: Int,
//        @Query("page_size") page_size: Int,
//        @Query("search") query: String,
//    ): GamesResponse


}


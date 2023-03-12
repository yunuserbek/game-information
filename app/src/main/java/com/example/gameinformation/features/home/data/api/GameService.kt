package com.example.gameinformation.features.home.data.api

import com.example.gameinformation.features.home.data.model.GameResponse
import com.example.gameinformation.utilty.constants.Constants.TOKEN
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameService {
@GET("games")
suspend fun games(@Query("key") key:String = TOKEN):GameResponse
}
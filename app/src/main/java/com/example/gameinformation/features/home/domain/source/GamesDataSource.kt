package com.example.gameinformation.features.home.domain.source

import com.example.gameinformation.features.home.data.model.GamesResponse

interface GamesDataSource {
    suspend fun getGames(size:Int,page:Int,query:String):GamesResponse

  //  suspend fun getSearchGames(size:Int,page:Int,query:String):GamesResponse
}
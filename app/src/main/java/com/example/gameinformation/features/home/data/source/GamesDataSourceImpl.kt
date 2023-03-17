package com.example.gameinformation.features.home.data.source

import com.example.gameinformation.features.home.data.api.GameService
import com.example.gameinformation.features.home.data.model.GamesResponse
import com.example.gameinformation.features.home.domain.source.GamesDataSource

class GamesDataSourceImpl (private val remoteService: GameService): GamesDataSource {
    override suspend fun getGames(size:Int,page:Int,query:String): GamesResponse {
        return remoteService.games(page_size = size,page =page,query = query)
    }


}

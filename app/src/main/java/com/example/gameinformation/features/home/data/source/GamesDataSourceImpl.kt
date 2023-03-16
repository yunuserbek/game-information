package com.example.gameinformation.features.home.data.source

import com.example.gameinformation.features.home.data.api.GameService
import com.example.gameinformation.features.home.data.model.GameResponse
import com.example.gameinformation.features.home.domain.source.GamesDataSource

class GamesDataSourceImpl (private val remoteService: GameService): GamesDataSource {
    override suspend fun getGames(size:Int): GameResponse {
        return remoteService.games(page = size)
    }
}

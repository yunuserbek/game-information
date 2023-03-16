package com.example.gameinformation.features.home.domain.source

import com.example.gameinformation.features.home.data.model.GameResponse
import com.example.gameinformation.features.home.domain.entity.GamesUi

interface GamesDataSource {
    suspend fun getGames(size:Int):GameResponse
}
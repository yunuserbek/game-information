package com.example.gameinformation.features.home.domain.repository

import com.example.gameinformation.common.Resource
import com.example.gameinformation.features.home.domain.entity.GamesUi
import kotlinx.coroutines.flow.Flow

interface GetGamesRepository {

    suspend fun getGames(): Flow<Resource<List<GamesUi>>>

}
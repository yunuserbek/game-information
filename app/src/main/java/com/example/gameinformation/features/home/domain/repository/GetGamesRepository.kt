package com.example.gameinformation.features.home.domain.repository

import androidx.paging.PagingData
import com.example.gameinformation.common.Resource
import com.example.gameinformation.features.home.domain.entity.GamesUi
import kotlinx.coroutines.flow.Flow

interface GetGamesRepository {

    suspend fun getGames(size:Int): Flow<PagingData<GamesUi>>

    suspend fun getSearchGames(size:Int,query:String): Flow<PagingData<GamesUi>>

    fun getLastSearchedWords(): Flow<List<String>>

}
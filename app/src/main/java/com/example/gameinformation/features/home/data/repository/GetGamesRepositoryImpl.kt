package com.example.gameinformation.features.home.data.repository


import com.example.gameinformation.common.Resource
import com.example.gameinformation.features.home.domain.entity.GamesUi
import com.example.gameinformation.features.home.domain.mapper.ToGameMapper
import com.example.gameinformation.features.home.domain.repository.GetGamesRepository
import com.example.gameinformation.features.home.domain.source.GamesDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetGamesRepositoryImpl(private val gameDataSource: GamesDataSource) : GetGamesRepository {
    override suspend fun getGames(): Flow<Resource<List<GamesUi>>> = flow {
        emit(Resource.Loading)
        try{
            val game =gameDataSource.getGames().results?.map { it.ToGameMapper() }
            game?.let {
                    emit(Resource.Success(it))
            }

        }catch (e:Exception){
            emit(Resource.Error(e))
        }

    }
}
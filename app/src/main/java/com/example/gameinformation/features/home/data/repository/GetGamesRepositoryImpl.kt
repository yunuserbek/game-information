package com.example.gameinformation.features.home.data.repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.gameinformation.common.Resource
import com.example.gameinformation.features.home.data.paging.Paging
import com.example.gameinformation.features.home.domain.entity.GamesUi
import com.example.gameinformation.features.home.domain.mapper.ToGameMapper
import com.example.gameinformation.features.home.domain.repository.GetGamesRepository
import com.example.gameinformation.features.home.domain.source.GamesDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetGamesRepositoryImpl(private val gameDataSource: GamesDataSource) : GetGamesRepository {
    //    override suspend fun getGames(): Flow<PagingData<List<GamesUi>>> = flow {
//        emit(Resource.Loading)
//        try{
//            val game =gameDataSource.getGames().results?.map { it.ToGameMapper() }
//            game?.let {
//                    emit(Resource.Success(it))
//            }
//
//        }catch (e:Exception){
//            emit(Resource.Error(e))
//        }
//
//    }
    override suspend fun getGames(size: Int): Flow<PagingData<GamesUi>>  = flow{

        Pager(config = PagingConfig(size, maxSize = 100, enablePlaceholders = false),
            pagingSourceFactory = {
                Paging(
                    remoteDataSource = gameDataSource, size
                )
            }).flow.collect {

            emit(it) }


    }
}
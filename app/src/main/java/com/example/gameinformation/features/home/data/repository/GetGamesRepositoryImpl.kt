package com.example.gameinformation.features.home.data.repository


import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.gameinformation.common.extension.dataStore
import com.example.gameinformation.common.extension.titleCaseFirstChar
import com.example.gameinformation.features.home.data.paging.Paging
import com.example.gameinformation.features.home.data.paging.PagingSearch
import com.example.gameinformation.features.home.domain.entity.GamesUi
import com.example.gameinformation.features.home.domain.repository.GetGamesRepository
import com.example.gameinformation.features.home.domain.source.GamesDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class GetGamesRepositoryImpl(private val gameDataSource: GamesDataSource,context: Context) : GetGamesRepository {
    private val dataStore = context.dataStore

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

        Pager(config = PagingConfig(size, maxSize = 100, enablePlaceholders =false ),
            pagingSourceFactory = {
                Paging(
                    remoteDataSource = gameDataSource, size
                )
            }).flow.collect {

            emit(it) }


    }

    override suspend fun getSearchGames(size: Int, query: String): Flow<PagingData<GamesUi>> =flow {
        Pager(config = PagingConfig(size, maxSize = 100, enablePlaceholders =false ),
            pagingSourceFactory = {
                PagingSearch(
                    gameDataSource = gameDataSource, size,query)

            }).flow.collect {
            val lateSearched = stringPreferencesKey("lateSearched")
            getLastSearchedWords().collect {

                if (!it.contains(query.titleCaseFirstChar())) {
                    if (it.size > 4) {
                        it.removeAt(0)
                        it.add(query.titleCaseFirstChar())
                    } else {
                        it.add(query.titleCaseFirstChar())
                    }
                    val string = it.joinToString(",")
                    dataStore.edit { edit ->
                        edit[lateSearched] = string
                    }
                }
            }

            emit(it) }


    }



    override fun getLastSearchedWords(): Flow<MutableList<String>> = flow {
        val lateSearched = stringPreferencesKey("lateSearched")
        val valueList = dataStore.data.first()[lateSearched]?.split(",")?.toMutableList()
        valueList?.let {
            emit(it)
        } ?: emit(mutableListOf())
    }
}
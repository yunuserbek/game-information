package com.example.gameinformation.features.home.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.gameinformation.features.home.domain.entity.GamesUi
import com.example.gameinformation.features.home.domain.mapper.ToGameMapper
import com.example.gameinformation.features.home.domain.source.GamesDataSource

class PagingSearch(
    private val gameDataSource: GamesDataSource,
    private val size: Int,
    private val query: String
) : PagingSource<Int, GamesUi>() {
    override fun getRefreshKey(state: PagingState<Int, GamesUi>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GamesUi> {
        val currentPage = params.key ?: 1
        val response = gameDataSource.getSearchGames(size, currentPage, query)

        return try{
            LoadResult.Page(
                data = response.results.map { it.ToGameMapper() } ?: emptyList(),
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (response.next == null) null else currentPage + 1)
        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}
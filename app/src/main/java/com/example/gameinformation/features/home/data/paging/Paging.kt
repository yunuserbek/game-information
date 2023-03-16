package com.example.gameinformation.features.home.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.gameinformation.features.home.domain.entity.GamesUi
import com.example.gameinformation.features.home.domain.mapper.ToGameMapper
import com.example.gameinformation.features.home.domain.source.GamesDataSource

class Paging(
    private val remoteDataSource: GamesDataSource,
    private val size: Int
) : PagingSource<Int, GamesUi>() {
    override fun getRefreshKey(state: PagingState<Int, GamesUi>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GamesUi> {
        return try {
            val currentPage = params.key ?: 1
            val response = remoteDataSource.getGames(size)
            LoadResult.Page(
                data = response.results?.map { it.ToGameMapper() }!!,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }


}
package com.example.gameinformation.features.home.data.paging

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.gameinformation.features.home.domain.entity.GamesUi
import com.example.gameinformation.features.home.domain.mapper.ToGameMapper
import com.example.gameinformation.features.home.domain.source.GamesDataSource

class Paging (  private val remoteDataSource: GamesDataSource,
                private val size:Int)
    : PagingSource<Int, GamesUi>(){
    override fun getRefreshKey(state: PagingState<Int, GamesUi>): Int? {

        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GamesUi> {
        return try {
            val currentPage = params.key ?: 1
            val response = remoteDataSource.getGames(size,currentPage)
            val prevKey = if (currentPage == 1) null else currentPage - 1

           // val nextPageNumber = checkNextOrPrevPage(response.next)
            //val prevPageNumber = checkNextOrPrevPage(response.previous)
            LoadResult.Page(

                data = response.results.map { it.ToGameMapper() } ?: emptyList(),
                prevKey =prevKey,
                nextKey = currentPage +1
            )
        }catch (e: Exception) {
            LoadResult.Error(e)
        }

    }

    private fun checkNextOrPrevPage(item:String?): Int? {
        if(item != null) {
            val uri = Uri.parse(item)
            val nextPageQuery = uri.getQueryParameter("page")
            return nextPageQuery?.toInt()
        }else{
            return null
        }
    }


}
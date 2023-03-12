package com.example.gameinformation.features.detail.data.repository

import com.example.gameinformation.common.Resource
import com.example.gameinformation.features.detail.domain.entity.DetailUiModel
import com.example.gameinformation.features.detail.domain.mapper.toDetailMapper
import com.example.gameinformation.features.detail.domain.repository.DetailRepository
import com.example.gameinformation.features.detail.domain.source.GameDetailSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DetailRepositoryImpl(private val gameDetailSource: GameDetailSource): DetailRepository {
    override suspend fun getDetail(id: Int): Flow<Resource<DetailUiModel>> =flow {
       emit(Resource.Loading)
        try{
            val detail = gameDetailSource.getDetail(id).toDetailMapper()
            detail?.let {
                emit(Resource.Success(it))
            }
        }catch (e:Exception){
            emit(Resource.Error(e))
        }
    }

}
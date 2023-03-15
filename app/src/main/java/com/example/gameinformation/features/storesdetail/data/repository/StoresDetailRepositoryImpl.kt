package com.example.gameinformation.features.storesdetail.data.repository

import com.example.gameinformation.common.Resource
import com.example.gameinformation.features.stores.domain.entity.StoreUIModel
import com.example.gameinformation.features.storesdetail.data.model.StoresDetailResponse
import com.example.gameinformation.features.storesdetail.domain.entity.StoresDetailUiModel
import com.example.gameinformation.features.storesdetail.domain.mapper.toStoresMapper
import com.example.gameinformation.features.storesdetail.domain.repository.StoresDetailRepository
import com.example.gameinformation.features.storesdetail.domain.source.StoreDetailDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class StoresDetailRepositoryImpl(private val storesDetailDataSource: StoreDetailDataSource) :
    StoresDetailRepository {
    override suspend fun getStoresDetail(id: Int): Flow<Resource<StoresDetailUiModel>> = flow {
        emit(Resource.Loading)
        try{
            val storeResponse = storesDetailDataSource.getStoreDetail(id).toStoresMapper()
            storeResponse?.let {
                emit(Resource.Success(it))
            }
        }catch (e:Exception){
            emit(Resource.Error(e))
        }

    }

}



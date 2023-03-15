package com.example.gameinformation.features.stores.data.repository

import com.example.gameinformation.common.Resource
import com.example.gameinformation.features.stores.data.model.StoreResponse
import com.example.gameinformation.features.stores.domain.entity.StoreUIModel
import com.example.gameinformation.features.stores.domain.mapper.toStoreMapper
import com.example.gameinformation.features.stores.domain.repository.StoreRepository
import com.example.gameinformation.features.stores.domain.source.StoreDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class StoreRepositoryImpl(private var storeDataSource: StoreDataSource) : StoreRepository {
    override suspend fun getStores(): Flow<Resource<List<StoreUIModel>>> = flow {
        emit(Resource.Loading)

        try {
            val stores =storeDataSource.getStores().results?.map { it.toStoreMapper() }
            stores?.let {
                emit(Resource.Success(it))
            }



        }catch (e:Exception){
            emit(Resource.Error(e))
        }


    }

}
package com.example.gameinformation.features.storesdetail.data.source

import com.example.gameinformation.features.storesdetail.data.api.StoresDetailService
import com.example.gameinformation.features.storesdetail.data.model.StoresDetailResponse
import com.example.gameinformation.features.storesdetail.domain.source.StoreDetailDataSource

class StoreDetailDataSourceImpl(private var storesDetailService: StoresDetailService): StoreDetailDataSource{
    override suspend fun getStoreDetail(id:Int): StoresDetailResponse {
       return storesDetailService.getStoresDetail(id)
    }

}
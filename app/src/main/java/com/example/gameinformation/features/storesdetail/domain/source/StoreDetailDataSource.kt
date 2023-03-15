package com.example.gameinformation.features.storesdetail.domain.source

import com.example.gameinformation.features.storesdetail.data.model.StoresDetailResponse

interface StoreDetailDataSource {
    suspend fun getStoreDetail(id:Int): StoresDetailResponse
}
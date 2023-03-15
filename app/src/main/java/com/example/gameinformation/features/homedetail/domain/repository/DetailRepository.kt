package com.example.gameinformation.features.homedetail.domain.repository

import com.example.gameinformation.common.Resource
import com.example.gameinformation.features.homedetail.domain.entity.DetailUiModel
import kotlinx.coroutines.flow.Flow

interface DetailRepository {
    suspend fun getDetail(id: Int):Flow<Resource<DetailUiModel>>
}
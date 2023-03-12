package com.example.gameinformation.features.detail.domain.source

import com.example.gameinformation.features.detail.data.model.DetailResponse

interface GameDetailSource {
    suspend fun getDetail(id: Int):DetailResponse
}
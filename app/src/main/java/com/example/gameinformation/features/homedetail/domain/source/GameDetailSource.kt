package com.example.gameinformation.features.homedetail.domain.source

import com.example.gameinformation.features.homedetail.data.model.DetailResponse

interface GameDetailSource {
    suspend fun getDetail(id: Int):DetailResponse
}
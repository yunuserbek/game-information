package com.example.gameinformation.features.detail.data.source

import com.example.gameinformation.features.detail.data.api.GameDetailService
import com.example.gameinformation.features.detail.data.model.DetailResponse
import com.example.gameinformation.features.detail.domain.source.GameDetailSource

class GameDetailSourceImpl(private val gameDetailService: GameDetailService):GameDetailSource{
    override suspend fun getDetail(id: Int): DetailResponse{
        return gameDetailService.gameDetail(id)
    }

}
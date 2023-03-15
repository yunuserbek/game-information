package com.example.gameinformation.features.homedetail.data.source

import com.example.gameinformation.features.homedetail.data.api.GameDetailService
import com.example.gameinformation.features.homedetail.data.model.DetailResponse
import com.example.gameinformation.features.homedetail.domain.source.GameDetailSource

class GameDetailSourceImpl(private val gameDetailService: GameDetailService):GameDetailSource{
    override suspend fun getDetail(id: Int): DetailResponse{
        return gameDetailService.gameDetail(id)
    }

}
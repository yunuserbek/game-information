package com.example.gameinformation.features.home.domain.usecase

import com.example.gameinformation.features.home.domain.repository.GetGamesRepository
import javax.inject.Inject

class SearchUseCase @Inject constructor(private var gameRepository: GetGamesRepository) {
    suspend operator fun invoke(size:Int,query:String) = gameRepository.getSearchGames(size,query)

}
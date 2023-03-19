package com.example.gameinformation.features.home.domain.usecase

import com.example.gameinformation.features.home.domain.repository.GetGamesRepository
import javax.inject.Inject

class GamesUseCase @Inject constructor(private val getGamesRepository: GetGamesRepository) {
    suspend operator fun invoke(size:Int) = getGamesRepository.getGames(size)
}
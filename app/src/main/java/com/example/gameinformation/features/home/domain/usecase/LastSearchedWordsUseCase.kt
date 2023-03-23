package com.example.gameinformation.features.home.domain.usecase

import com.example.gameinformation.features.home.domain.repository.GetGamesRepository
import javax.inject.Inject

class LastSearchedWordsUseCase @Inject constructor(
    private val wordsRepository: GetGamesRepository
) {
  operator fun invoke() = wordsRepository.getLastSearchedWords()
}
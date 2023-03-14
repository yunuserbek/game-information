package com.example.gameinformation.features.stores.domain.usecase

import com.example.gameinformation.features.stores.domain.repository.StoreRepository
import javax.inject.Inject

class StoreUseCase @Inject constructor(private var storeRepository: StoreRepository) {
    suspend operator fun invoke() = storeRepository.getStores()
}
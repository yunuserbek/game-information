package com.example.gameinformation.features.storesdetail.domain.usecase

import com.example.gameinformation.features.storesdetail.domain.repository.StoresDetailRepository
import javax.inject.Inject

class StoresDetailUseCase @Inject constructor(private val getStoresDetailRepository: StoresDetailRepository) {
    suspend operator fun invoke(id: Int) = getStoresDetailRepository.getStoresDetail(id)



}
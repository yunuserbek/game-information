package com.example.gameinformation.features.detail.domain.usecase

import com.example.gameinformation.features.detail.domain.repository.DetailRepository
import javax.inject.Inject

class DetailUseCase @Inject constructor(private val getDetailRepository: DetailRepository){
    suspend operator fun invoke(id:Int) = getDetailRepository.getDetail(id)
}
package com.example.gameinformation.features.detail.domain.mapper

import com.example.gameinformation.features.detail.data.model.DetailResponse
import com.example.gameinformation.features.detail.domain.entity.DetailUiModel

fun DetailResponse.toDetailMapper() = DetailUiModel(
    backgroundİmage = backgroundİmage?:"",
    description = description?:"",
    rating = rating?:0.0,
    date = released?: ""

)
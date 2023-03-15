package com.example.gameinformation.features.homedetail.domain.mapper

import com.example.gameinformation.features.homedetail.data.model.DetailResponse
import com.example.gameinformation.features.homedetail.domain.entity.DetailUiModel

fun DetailResponse.toDetailMapper() = DetailUiModel(
    backgroundİmage = backgroundİmage?:"",
    description = description?:"",
    rating = rating?:0.0,
    date = released?: "",
    header =name?:""

)
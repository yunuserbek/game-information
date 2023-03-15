package com.example.gameinformation.features.storesdetail.domain.mapper

import com.example.gameinformation.features.storesdetail.data.model.StoresDetailResponse
import com.example.gameinformation.features.storesdetail.domain.entity.StoresDetailUiModel


fun StoresDetailResponse.toStoresMapper() =StoresDetailUiModel(
    name= name?:"",
    imageBackground = imageBackground?:"",
    description = description?:""
)
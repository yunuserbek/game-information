package com.example.gameinformation.features.stores.domain.mapper

import com.example.gameinformation.features.stores.data.model.Result
import com.example.gameinformation.features.stores.domain.entity.StoreUIModel

fun Result.toStoreMapper() =StoreUIModel(
    domain = domain?:"",
    gamesCount = gamesCount?:0,
    id = id?:0,
    imageBackground = imageBackground?:"",
    name = name?:"",
)
package com.example.gameinformation.features.home.domain.mapper

import com.example.gameinformation.features.home.data.model.Result
import com.example.gameinformation.features.home.domain.entity.GamesUi


fun Result.ToGameMapper() = GamesUi(
    image = this.backgroundİmage ?: "",
    name = this.name ?: "",
    usergame = this.userGame ?: "",
    released = this.released?:"",
    rating = this.rating ?: 0.0
)
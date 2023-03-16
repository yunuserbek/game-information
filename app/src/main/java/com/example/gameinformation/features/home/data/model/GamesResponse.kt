package com.example.gameinformation.features.home.data.model

import com.google.gson.annotations.SerializedName

data class GamesResponse(
    @SerializedName("count") var count: Int,
    @SerializedName("next") var next: String,
    @SerializedName("previous") var previous: String,
    @SerializedName("results") var results: List<Result>
)

package com.example.gameinformation.features.stores.data.model


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("domain")
    val domain: String?,
    @SerializedName("games")
    val games: List<Game>?,
    @SerializedName("games_count")
    val gamesCount: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image_background")
    val imageBackground: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug")
    val slug: String?
)
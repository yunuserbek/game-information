package com.example.gameinformation.features.storesdetail.data.model


import com.google.gson.annotations.SerializedName

data class StoresDetailResponse(
    @SerializedName("description")
    val description: String?,
    @SerializedName("domain")
    val domain: String?,
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
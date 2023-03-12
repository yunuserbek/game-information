package com.example.gameinformation.features.detail.data.model


import com.google.gson.annotations.SerializedName

data class MetacriticPlatform(
    @SerializedName("metascore")
    val metascore: Int?,
    @SerializedName("platform")
    val platform: Platform?,
    @SerializedName("url")
    val url: String?
)
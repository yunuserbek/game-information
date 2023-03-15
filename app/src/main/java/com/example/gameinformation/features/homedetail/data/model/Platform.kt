package com.example.gameinformation.features.homedetail.data.model


import com.google.gson.annotations.SerializedName

data class Platform(
    @SerializedName("name")
    val name: String?,
    @SerializedName("platform")
    val platform: Int?,
    @SerializedName("slug")
    val slug: String?
)
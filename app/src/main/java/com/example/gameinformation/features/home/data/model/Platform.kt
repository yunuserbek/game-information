package com.example.gameinformation.features.home.data.model


import com.google.gson.annotations.SerializedName

data class Platform(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug")
    val slug: String?
)
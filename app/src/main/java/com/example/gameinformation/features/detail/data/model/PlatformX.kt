package com.example.gameinformation.features.detail.data.model


import com.google.gson.annotations.SerializedName

data class PlatformX(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug")
    val slug: String?
)
package com.example.gameinformation.features.detail.data.model


import com.google.gson.annotations.SerializedName

data class ParentPlatform(
    @SerializedName("platform")
    val platform: PlatformX?
)
package com.example.gameinformation.features.homedetail.data.model


import com.google.gson.annotations.SerializedName

data class ParentPlatform(
    @SerializedName("platform")
    val platform: PlatformX?
)
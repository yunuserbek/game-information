package com.example.gameinformation.features.home.data.model


import com.google.gson.annotations.SerializedName

data class RequirementsRu(
    @SerializedName("minimum")
    val minimum: String?,
    @SerializedName("recommended")
    val recommended: String?
)
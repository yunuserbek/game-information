package com.example.gameinformation.features.home.data.model


import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("years")
    val years: List<Year>?
)
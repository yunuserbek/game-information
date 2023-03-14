package com.example.gameinformation.features.stores.data.model


import com.google.gson.annotations.SerializedName

data class Game(
    @SerializedName("added")
    val added: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug")
    val slug: String?
)
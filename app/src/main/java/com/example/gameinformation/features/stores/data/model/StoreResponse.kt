package com.example.gameinformation.features.stores.data.model


import com.google.gson.annotations.SerializedName

data class StoreResponse(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: Any?,
    @SerializedName("previous")
    val previous: Any?,
    @SerializedName("results")
    val results: List<Result?>?
)
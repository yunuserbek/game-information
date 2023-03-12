package com.example.gameinformation.features.home.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GamesUi(
    val name: String?,
    val image: String?,
    val usergame: String?,
    val released: String?,
    val rating: Double?,
    val idUse: Int?,
) : Parcelable

package com.example.gameinformation.common

import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.addSnap() {
    val snapHelper = PagerSnapHelper()
    snapHelper.attachToRecyclerView(this)
}
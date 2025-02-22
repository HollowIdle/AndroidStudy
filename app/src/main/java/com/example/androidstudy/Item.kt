package com.example.androidstudy

import androidx.annotation.DrawableRes

data class Item(
    val id: Int,
    val title: String,
    val description: String,
    @DrawableRes val imageRes: Int
)
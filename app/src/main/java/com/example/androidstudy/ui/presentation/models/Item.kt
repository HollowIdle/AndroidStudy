package com.example.androidstudy.ui.presentation.models

import androidx.annotation.DrawableRes

data class Item(
    val id: Int,
    val title: String,
    val description: String,
    @DrawableRes val imageRes: Int
)
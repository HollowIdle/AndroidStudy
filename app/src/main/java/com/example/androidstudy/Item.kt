package com.example.androidstudy

import android.graphics.Bitmap

data class Item(
    val id: Int,
    val title: String,
    val description: String,
    val image: Bitmap // в твоём случае не обязательно использовать Int и передать ссылку на drawable
)
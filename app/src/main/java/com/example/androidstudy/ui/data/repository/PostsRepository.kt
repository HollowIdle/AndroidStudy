package com.example.androidstudy.ui.data.repository

import com.example.androidstudy.ui.data.remote.dto.DataPostDto

interface PostsRepository {
    suspend fun getPosts() : List<DataPostDto>
}
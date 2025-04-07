package com.example.androidstudy.ui.domain.repositories

import com.example.androidstudy.ui.data.local.PostEntity
import com.example.androidstudy.ui.data.remote.dto.PostDto

interface PostsRepository {
    suspend fun getPosts() : List<PostDto>
    suspend fun getLocalPosts(): List<PostEntity>
    suspend fun getPostInfoFromLocal() : PostEntity?
}
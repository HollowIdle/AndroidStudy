package com.example.androidstudy.ui.domain.use_cases

import com.example.androidstudy.ui.data.remote.dto.toDomainPostList
import com.example.androidstudy.ui.data.repository.PostsRepositoryImpl

class PostsUseCase {
    fun getPosts() = PostsRepositoryImpl().getPosts().toDomainPostList()
}
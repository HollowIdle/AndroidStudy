package com.example.androidstudy.ui.domain.use_cases

import com.example.androidstudy.ui.data.remote.dto.toDomainPost
import com.example.androidstudy.ui.data.repository.PostsRepositoryImpl

class GetPostInfoUseCase {
    fun getPostInfo() = PostsRepositoryImpl().getPostInfo().toDomainPost()
}
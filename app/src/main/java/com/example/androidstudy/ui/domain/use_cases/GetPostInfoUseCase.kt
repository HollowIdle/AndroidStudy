package com.example.androidstudy.ui.domain.use_cases

import com.example.androidstudy.ui.domain.repositories.PostsRepository
import javax.inject.Inject

class GetPostInfoUseCase @Inject constructor(
    private val postsRepository: PostsRepository
) {
    //fun getPostInfo() = postsRepository.getPostInfo().toDomainPost()
}
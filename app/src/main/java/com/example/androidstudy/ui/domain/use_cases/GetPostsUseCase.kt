package com.example.androidstudy.ui.domain.use_cases

import com.example.androidstudy.ui.data.remote.dto.toDomainPost
import com.example.androidstudy.ui.domain.models.DomainPost
import com.example.androidstudy.ui.domain.repositories.PostsRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val postsRepository: PostsRepository
) {
    suspend fun getPosts() : List<DomainPost> = postsRepository.getPosts().map { postDto ->
        postDto.toDomainPost()
    }
}
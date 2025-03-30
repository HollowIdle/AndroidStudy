package com.example.androidstudy.ui.data.repository

import com.example.androidstudy.ui.data.remote.dto.PostDto
import com.example.androidstudy.ui.data.repository.remote.PostsRemote
import com.example.androidstudy.ui.domain.repositories.PostsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostsRepositoryImpl @Inject constructor(
    private val postsRemote: PostsRemote
) : PostsRepository {

    override suspend fun getPosts(): List<PostDto> = postsRemote.getPosts().posts.orEmpty()

}
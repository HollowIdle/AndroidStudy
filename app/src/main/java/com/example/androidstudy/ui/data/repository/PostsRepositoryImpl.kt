package com.example.androidstudy.ui.data.repository

import com.example.androidstudy.ui.data.remote.dto.DataPostDto
import com.example.androidstudy.ui.data.repository.remote.PostsRemoteImpl
import com.example.androidstudy.ui.domain.repositories.PostRepository

class PostsRepositoryImpl : PostRepository {
    override fun getPosts(): List<DataPostDto> = PostsRemoteImpl().getPosts()
    override fun getPostInfo(): DataPostDto = PostsRemoteImpl().getPostInfo()
}
package com.example.androidstudy.ui.data.repository.remote

import com.example.androidstudy.ui.data.remote.dto.ResponseDto

interface PostsRemote {
    suspend fun getPosts(): ResponseDto
}
package com.example.androidstudy.ui.data.repository.remote

import com.example.androidstudy.ui.data.remote.dto.DataPostDto

interface PostsRemote {
    fun getPosts(): List<DataPostDto>
    fun getPostInfo(): DataPostDto
}
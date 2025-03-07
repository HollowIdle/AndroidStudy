package com.example.androidstudy.ui.domain.repositories

import com.example.androidstudy.ui.data.remote.dto.DataPostDto

interface PostRepository {
    fun getPosts() : List<DataPostDto>
    fun getPostInfo() : DataPostDto
}
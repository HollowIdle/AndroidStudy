package com.example.androidstudy.ui.data.repository.remote

import com.example.androidstudy.ui.data.remote.api.PostApi
import com.example.androidstudy.ui.data.remote.dto.ResponseDto
import javax.inject.Inject

class PostsRemoteImpl @Inject constructor(
    private val postApi: PostApi
) : PostsRemote {

    override suspend fun getPosts(): ResponseDto =
        postApi.getLastNews()
}
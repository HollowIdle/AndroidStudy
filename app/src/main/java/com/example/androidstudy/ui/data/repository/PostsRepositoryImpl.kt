package com.example.androidstudy.ui.data.repository

import com.example.androidstudy.ui.data.local.PostEntity
import com.example.androidstudy.ui.data.remote.dto.PostDto
import com.example.androidstudy.ui.data.remote.dto.toLocalPost
import com.example.androidstudy.ui.data.repository.local.PostsLocal
import com.example.androidstudy.ui.data.repository.remote.PostsRemote
import com.example.androidstudy.ui.domain.repositories.PostsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostsRepositoryImpl @Inject constructor(
    private val postsRemote: PostsRemote,
    private val postsLocal: PostsLocal
) : PostsRepository {

    override suspend fun getPosts(): List<PostDto> {

        val postList = postsRemote.getPosts().posts.orEmpty()

        if(postList.isNotEmpty()){
            postList.forEach{ postDto ->
                postsLocal.insertPost(postEntity = postDto.toLocalPost())
            }
        }

        return postList
    }

    override suspend fun getLocalPosts(): List<PostEntity> = postsLocal.getLocalPosts().orEmpty()
    override suspend fun getPostInfoFromLocal(): PostEntity?{
        return null
    }



}
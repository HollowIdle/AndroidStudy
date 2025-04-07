package com.example.androidstudy.ui.di.module.repositories

import com.example.androidstudy.ui.data.local.PostsDao
import com.example.androidstudy.ui.data.repository.local.PostsLocal
import com.example.androidstudy.ui.data.repository.local.PostsLocalImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LocalRepositoryModule {

    @Provides
    fun providePostsLocal(postsDao: PostsDao): PostsLocal =
        PostsLocalImpl(postsDao = postsDao)
}
package com.example.androidstudy.ui.di.module.repositories

import com.example.androidstudy.ui.data.repository.PostsRepositoryImpl
import com.example.androidstudy.ui.data.repository.local.PostsLocal
import com.example.androidstudy.ui.data.repository.remote.PostsRemote
import com.example.androidstudy.ui.domain.repositories.PostsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providePostsRepository(
        postsRemote: PostsRemote,
        postsLocal: PostsLocal
    ) : PostsRepository =
        PostsRepositoryImpl(
            postsRemote = postsRemote,
            postsLocal=postsLocal
        )
}
package com.example.androidstudy.ui.di.module.repositories

import com.example.androidstudy.ui.data.remote.api.PostApi
import com.example.androidstudy.ui.data.repository.remote.PostsRemote
import com.example.androidstudy.ui.data.repository.remote.PostsRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class RemoteRepositoryModule {

    @Provides
    fun providePostsRemote(postApi: PostApi): PostsRemote = PostsRemoteImpl(postApi = postApi)
}
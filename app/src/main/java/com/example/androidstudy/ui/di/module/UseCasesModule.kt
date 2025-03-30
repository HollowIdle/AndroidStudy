package com.example.androidstudy.ui.di.module

import com.example.androidstudy.ui.domain.repositories.PostsRepository
import com.example.androidstudy.ui.domain.use_cases.GetPostInfoUseCase
import com.example.androidstudy.ui.domain.use_cases.GetPostsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {
    @Provides
    fun providePostInfoUseCase(postsRepository: PostsRepository) =
        GetPostInfoUseCase(postsRepository = postsRepository)

    @Provides
    fun provideGetPostsUseCase(postsRepository: PostsRepository) =
        GetPostsUseCase(postsRepository = postsRepository)
}
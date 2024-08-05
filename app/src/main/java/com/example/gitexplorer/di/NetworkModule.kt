package com.example.gitexplorer.di

import com.example.gitexplorer.data.source.GithubApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideGithubApiService(): GithubApiService {
        return GithubApiService.create()
    }
}

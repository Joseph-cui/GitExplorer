package com.example.gitexplorer.data.source

import com.example.gitexplorer.data.source.model.response.GithubRepoResp
import com.example.gitexplorer.data.source.model.response.GithubUserResp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Joseph Cui on 2024-08-04.
 */
interface GithubApiService {

    @GET("users/{userId}")
    suspend fun getUser(@Path("userId") userId: String): GithubUserResp

    @GET("users/{userId}/repos")
    suspend fun getRepo(@Path("userId") userId: String): List<GithubRepoResp>


    companion object {
        private const val BASE_URL = "https://api.github.com/"

        fun create(): GithubApiService {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubApiService::class.java)
        }
    }
}
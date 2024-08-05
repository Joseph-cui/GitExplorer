package com.example.gitexplorer.data.repository

import com.example.gitexplorer.data.source.GithubApiService
import com.example.gitexplorer.data.source.model.response.GithubRepoResp
import com.example.gitexplorer.data.source.model.response.GithubUserResp
import javax.inject.Inject

/**
 * Created by Joseph Cui on 2024-08-04.
 */
class GithubReposity @Inject constructor(private val service: GithubApiService) {

    suspend fun getUser(userId: String): GithubUserResp {
        return service.getUser(userId)
    }

    suspend fun getRepo(userId: String): List<GithubRepoResp> {
        return service.getRepo(userId)
    }

}
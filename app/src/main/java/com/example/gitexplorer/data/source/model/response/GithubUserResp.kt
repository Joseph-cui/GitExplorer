package com.example.gitexplorer.data.source.model.response

import com.google.gson.annotations.SerializedName

/**
 * Created by Joseph Cui on 2024-08-04.
 */
data class GithubUserResp (
    @field:SerializedName("name") val name: String,
    @field:SerializedName("avatar_url") val avatarUrl: String
)
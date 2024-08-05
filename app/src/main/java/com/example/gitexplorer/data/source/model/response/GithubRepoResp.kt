package com.example.gitexplorer.data.source.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by Joseph Cui on 2024-08-04.
 */
@Parcelize
data class GithubRepoResp(
    @field:SerializedName("name") val name: String,
    @field:SerializedName("description") val description: String,
    @field:SerializedName("updated_at") val updatedAt: String,
    @field:SerializedName("stargazers_count") val count: Int,
    @field:SerializedName("forks") val forks: Int,
    ) : Parcelable

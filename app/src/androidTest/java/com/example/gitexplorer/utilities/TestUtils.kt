/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.gitexplorer.utilities

import com.example.gitexplorer.data.source.model.response.GithubRepoResp

/**
 * [GithubRepoResp] objects used for tests.
 */
val testRepos = arrayListOf(
    GithubRepoResp("demo", "A libery demo", "2024-08-01T13:12:34Z", 23,1),
    GithubRepoResp("picture creater", "create a great picture", "2023-08-01T13:12:34Z", 267,6576),
    GithubRepoResp("java library", "Spring Boot library", "2024-07-01T13:12:34Z", 28,454),
)
val testRepo = testRepos[0]
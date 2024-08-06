package com.example.gitexplorer.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gitexplorer.data.repository.GithubReposity
import com.example.gitexplorer.data.source.model.response.GithubRepoResp
import com.example.gitexplorer.data.source.model.response.GithubUserResp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Joseph Cui on 2024-08-05.
 */
@HiltViewModel
class GitDetailScreenViewModel  @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: GithubReposity
) : ViewModel() {

    private val _gitRepo = MutableStateFlow<GithubRepoResp?>(null)
    val gitRepo: StateFlow<GithubRepoResp?> = _gitRepo

    fun onCreated(repo: GithubRepoResp?) {
        viewModelScope.launch {
            _gitRepo.emit(repo)
        }
    }

}
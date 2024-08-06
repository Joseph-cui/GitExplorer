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

@HiltViewModel
class SearchScreenViewModel  @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: GithubReposity
) : ViewModel() {

    private val _gitUser = MutableStateFlow<GithubUserResp?>(null)
    val gitUser: StateFlow<GithubUserResp?> = _gitUser

    private val _gitRepo = MutableStateFlow<List<GithubRepoResp>>(emptyList())
    val gitRepo: StateFlow<List<GithubRepoResp>> = _gitRepo

    fun searchUser(userId: String) {
        viewModelScope.launch {
            try {
                _gitUser.emit(repository.getUser(userId))
                _gitRepo.emit(repository.getRepo(userId))
            } catch (e: Exception) {
                //TODO show error message

                //clear last search result
                _gitUser.emit(null)
                _gitRepo.emit(ArrayList())
            }
        }
    }


}

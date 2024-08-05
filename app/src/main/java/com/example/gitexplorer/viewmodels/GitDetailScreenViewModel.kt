package com.example.gitexplorer.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.gitexplorer.data.repository.GithubReposity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Joseph Cui on 2024-08-05.
 */
@HiltViewModel
class GitDetailScreenViewModel  @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: GithubReposity
) : ViewModel() {

}
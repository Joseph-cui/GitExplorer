package com.example.gitexplorer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.gitexplorer.databinding.FragmentGitDetailBinding
import com.example.gitexplorer.viewmodels.GitDetailScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Joseph Cui on 2024-08-03.
 */
@AndroidEntryPoint
class GitDetailFragment : Fragment() {
    private val viewModel: GitDetailScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentGitDetailBinding>(
            inflater,
            R.layout.fragment_git_detail,
            container,
            false
        )
        return binding.root
    }
}
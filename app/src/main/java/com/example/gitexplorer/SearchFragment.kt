package com.example.gitexplorer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitexplorer.adapter.SearchResultAdapter
import com.example.gitexplorer.data.source.model.response.GithubRepoResp
import com.example.gitexplorer.data.source.model.response.GithubUserResp
import com.example.gitexplorer.databinding.FragmentSearchScreenBinding
import com.example.gitexplorer.viewmodels.SearchScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by Joseph Cui on 2024-08-03.
 */
@AndroidEntryPoint
class SearchFragment: Fragment() {
    private val viewModel: SearchScreenViewModel by viewModels()
    private val adapter = SearchResultAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<FragmentSearchScreenBinding>(
            inflater,
            R.layout.fragment_search_screen,
            container,
            false
        ).apply {
            gitRepoList.layoutManager = LinearLayoutManager(requireContext())
            gitRepoList.adapter = adapter

            searchButton.setOnClickListener {
                val userId = gitSearchId.text?.trim().toString()
                viewModel.searchUser(userId)
            }

            lifecycleScope.launch {
                viewModel.gitUser.collect{ user -> gitUser = user}
            }
            lifecycleScope.launch {
                viewModel.gitRepo.collect{repos -> adapter.submitList(repos)}
            }

        }
//        binding.gitRepoList.layoutManager = LinearLayoutManager(requireContext())
//        binding.gitRepoList.adapter = adapter
//
//        subscribeUi()
//        binding.searchButton.setOnClickListener {
//            val userId = binding.gitSearchId.text?.trim().toString()
//            viewModel.searchUser(userId)
//        }
        return binding.root
    }

}
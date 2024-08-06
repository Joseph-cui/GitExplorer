package com.example.gitexplorer.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gitexplorer.SearchFragmentDirections
import com.example.gitexplorer.data.source.model.response.GithubRepoResp
import com.example.gitexplorer.databinding.ListItemGitBinding

/**
 * Created by Joseph Cui on 2024-08-05.
 */
class SearchResultAdapter: ListAdapter<GithubRepoResp, RecyclerView.ViewHolder>(GithubRepoRespDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return GitRepoViewHolder(
            ListItemGitBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val gitRepo = getItem(position)
        (holder as GitRepoViewHolder).bind(gitRepo)
    }


    class GitRepoViewHolder(
        private val binding: ListItemGitBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                binding.gitrepo?.let { git ->
                    navigateToGit(git, it)
                }
            }
        }

        private fun navigateToGit(
            git: GithubRepoResp,
            view: View
        ) {
            val direction =
                SearchFragmentDirections.actionSearchFragmentToGitDetailFragment(git)
            view.findNavController().navigate(direction)
        }

        fun bind(item: GithubRepoResp) {
            binding.apply {
                gitrepo = item
                executePendingBindings()
            }
        }
    }

}

private class GithubRepoRespDiffCallback : DiffUtil.ItemCallback<GithubRepoResp>() {

    override fun areItemsTheSame(oldItem: GithubRepoResp, newItem: GithubRepoResp): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: GithubRepoResp, newItem: GithubRepoResp): Boolean {
        return oldItem == newItem
    }
}
package com.example.androidstudy.ui.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.androidstudy.R
import com.example.androidstudy.databinding.FragmentNewsBinding
import com.example.androidstudy.ui.domain.models.DomainPostList
import com.example.androidstudy.ui.presentation.adapters.RecyclerAdapter
import com.example.androidstudy.ui.presentation.view_models.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment(R.layout.fragment_news) {

    private lateinit var binding: FragmentNewsBinding

    private val viewModel: NewsViewModel by viewModels()

    private lateinit var adapter: RecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeRecyclerView()
        observeModel()
    }


    private fun initializeRecyclerView() {
        val posts = viewModel.newsList.value ?: DomainPostList().posts

        adapter = RecyclerAdapter(
            items = posts,
            onItemClick = {
                findNavController().navigate(
                    NewsFragmentDirections.actionNewsFragmentToNewsInfoFragment()
                )
            }
        )

        binding.newsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@NewsFragment.adapter
        }
    }

    private fun observeModel(){
        viewModel.newsList.observe(viewLifecycleOwner, Observer { newPosts ->
            adapter.submitList(newPosts)
            Glide.with(this)
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater,container,false)
        return binding.root
    }

}
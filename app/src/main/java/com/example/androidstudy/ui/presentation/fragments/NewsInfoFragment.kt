package com.example.androidstudy.ui.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.androidstudy.R
import com.example.androidstudy.databinding.FragmentNewsInfoBinding
import com.example.androidstudy.ui.domain.models.DomainPost
import com.example.androidstudy.ui.presentation.view_models.NewsInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsInfoFragment : Fragment() {

    private lateinit var binding : FragmentNewsInfoBinding
    private val viewModel: NewsInfoViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializing()
    }

    private fun initializing(){

        val postInfo = viewModel.postInfo.value ?: DomainPost()

        binding.apply {
            newsInfoTitleText.text = postInfo.title
            newsInfoDescriptionText.text = postInfo.description
        }

        binding.goBackButton.setOnClickListener{
            findNavController().navigate(R.id.action_newsInfoFragment_to_newsFragment)
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsInfoBinding.inflate(layoutInflater)
        return binding.root
    }

}
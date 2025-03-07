package com.example.androidstudy.ui.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidstudy.databinding.FragmentNewsInfoBinding

class NewsInfoFragment : Fragment() {

    lateinit var binding : FragmentNewsInfoBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializing()
    }

    fun initializing(){

        arguments?.let {
            val imageResId = NewsInfoFragmentArgs.fromBundle(it).imageId
            val titleText = NewsInfoFragmentArgs.fromBundle(it).title
            val descriptionText = NewsInfoFragmentArgs.fromBundle(it).description

            binding.newsInfoImage.setImageResource(imageResId)
            binding.newsInfoTitleText.setText(titleText)
            binding.newsInfoDescriptionText.setText(descriptionText)
        }

        binding.goBackButton.setOnClickListener{
            findNavController().navigateUp()
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsInfoBinding.inflate(layoutInflater)
        return binding.root
    }

}
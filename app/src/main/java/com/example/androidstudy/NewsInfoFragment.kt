package com.example.androidstudy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidstudy.databinding.FragmentNewsInfoBinding

class NewsInfoFragment : Fragment() {

    lateinit var binding : FragmentNewsInfoBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializing()
    }

    fun initializing(){

        val titleText = arguments?.getString(ARG_TITLE) ?: "No Title"
        val descriptionText = arguments?.getString(ARG_DESCRIPTION) ?: "No Description"
        val imageResId = arguments?.getInt(ARG_IMAGE) ?: R.drawable.ic_launcher_background

        binding.newsInfoImage.setImageResource(imageResId)
        binding.newsInfoTitleText.setText(titleText)
        binding.newsInfoDescriptionText.setText(descriptionText)

        binding.goBackButton.setOnClickListener{
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        private const val ARG_TITLE = "title"
        private const val ARG_DESCRIPTION = "description"
        private const val ARG_IMAGE = "image"

        fun newInstance(title: String, description: String, imageResId: Int) =
            NewsInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, title)
                    putString(ARG_DESCRIPTION, description)
                    putInt(ARG_IMAGE, imageResId)
                }
            }
    }

}
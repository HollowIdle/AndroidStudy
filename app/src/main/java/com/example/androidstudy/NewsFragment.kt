package com.example.androidstudy

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidstudy.databinding.FragmentNewsBinding

class NewsFragment : Fragment(R.layout.fragment_news) {

    private lateinit var binding: FragmentNewsBinding

    private val adapter by lazy {RecyclerAdapter()}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeRecyclerView()

    }

    private fun initializeRecyclerView() {
        binding.newsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@NewsFragment.adapter
        }
        adapter.submitList(listOfElements(requireContext()))
    }

    private fun listOfElements(context : Context?) : List<Item>{
        context ?: return emptyList()
        return (0 .. 50).map { i ->
            val imageId = if(i % 2 == 0) R.drawable.img else R.drawable.img_1
            Item(i,"Item $i","Description $i", imageId)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater,container,false)
        return binding.root
    }

}
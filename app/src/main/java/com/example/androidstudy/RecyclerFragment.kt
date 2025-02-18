package com.example.androidstudy

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidstudy.databinding.FragmentRecyclerBinding

class RecyclerFragment : Fragment(R.layout.fragment_recycler) {

    lateinit var binding: FragmentRecyclerBinding //todo private

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeRecyclerView()
    }

    fun initializeRecyclerView() { //todo private fun
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = RecyclerAdapter().apply {
                submitList(listOfElements(requireContext()))
            }
            //todo тебе часто придется обращаться к адаптеру извне, вынеси инициализацию в тело класса
            // подсказка: lateinit by lazy
        }
        //молодец что в отдельные методы начинаешь выносить
    }

    fun listOfElements(context : Context?) : List<Item>{ //todo private fun
        context ?: return emptyList()
        return (0 .. 50).map { i ->
            //todo можно оптимизировать (тудушка в Item.kt)
            val imageId = if(i % 2 == 0) R.drawable.img else R.drawable.img_1
            val bitmap = BitmapFactory.decodeResource(context.resources, imageId)
            Item(i,"Item $i","Description $i", bitmap)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecyclerBinding.inflate(layoutInflater)
        return binding.root
        //todo хорошая практика инициализации биндинга в onCreate, но в идеале обнулять ссылку в onDestroy
    }

}
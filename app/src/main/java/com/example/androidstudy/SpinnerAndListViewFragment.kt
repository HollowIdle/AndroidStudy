package com.example.androidstudy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.androidstudy.databinding.FragmentSpinnerAndListViewBinding

class SpinnerAndListViewFragment : Fragment(R.layout.fragment_spinner_and_list_view) {

    lateinit var binding: FragmentSpinnerAndListViewBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeSpinner()
        initializeListView()

        val nextPageButton = binding.nextPageButton

        nextPageButton.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_сontainer, RecyclerFragment())
                .addToBackStack(null)
                .commit()
        }

    }

    fun initializeSpinner(){
        val spinner = binding.spinner

        this.context?.let {
            ArrayAdapter.createFromResource(it,R.array.tech_companies_list, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item).also {
                    adapter ->
                adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }
        }
    }

    fun initializeListView(){
        val listView = binding.listView

        val listAdapter = ArrayAdapter(requireContext(),
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.tech_companies_list))

        listView.adapter = listAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSpinnerAndListViewBinding.inflate(layoutInflater)
        return binding.root
    }

}
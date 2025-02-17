package com.example.androidstudy

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.androidstudy.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Fragment Life Cycle Test","Fragment view created")

        val loginButton = binding.loginButton
        val loginField = binding.loginField
        val passwordField = binding.passwordField

        loginButton.isEnabled = false

        passwordField.doOnTextChanged { text, start, before, count ->
            loginButton.isEnabled = (text?.length ?: 0) >= 8
        }

        loginButton.setOnClickListener(){
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_сontainer,SecondFragment())
                .addToBackStack(null)
                .commit()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Fragment Life Cycle Test","Fragment CreateView")
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Fragment Life Cycle Test","Fragment attached")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Fragment Life Cycle Test","Fragment started")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Fragment Life Cycle Test","Fragment resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Fragment Life Cycle Test","Fragment paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Fragment Life Cycle Test","Fragment stopped")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Fragment Life Cycle Test","Fragment view destroyed")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Fragment Life Cycle Test","Fragment destroyed")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Fragment Life Cycle Test","Fragment detached")
    }

}
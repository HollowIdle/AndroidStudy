package com.example.androidstudy.ui.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.androidstudy.R
import com.example.androidstudy.databinding.FragmentLoginBinding
import com.example.androidstudy.ui.presentation.view_models.LoginViewModel

class LoginFragment : Fragment() {

    private lateinit var _binding : FragmentLoginBinding
    private val viewModel = LoginViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginButton = _binding.loginButton
        val loginField = _binding.loginField
        val passwordField = _binding.passwordField

        passwordField.doOnTextChanged { text, _, _, _ ->
            viewModel.onPasswordChanged(text.toString())
        }

        loginButton.setOnClickListener(){
            findNavController().navigate(R.id.action_loginFragment_to_newsFragment)
        }

        viewModel.isLoginButtonEnabled.observe(viewLifecycleOwner, Observer { isEnabled ->
            _binding.loginButton.isEnabled = isEnabled
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(layoutInflater)
        return _binding.root
    }

}
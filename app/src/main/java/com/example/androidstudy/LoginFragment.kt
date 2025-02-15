package com.example.androidstudy

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView


class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Fragment Life Cycle Test","Fragment view created")
        val fragmentContainer = view.findViewById<FragmentContainerView>(R.id.fragmentContainer)

        val loginButton = view.findViewById<Button>(R.id.loginButton)
        val loginTextField = view.findViewById<EditText>(R.id.loginField)
        val passwordTextField = view.findViewById<EditText>(R.id.passwordField)

        loginButton.isEnabled = false

        passwordTextField.addTextChangedListener(){
            loginButton.isEnabled = passwordTextField.text.length >= 8
        }

        loginButton.setOnClickListener(){
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer,SecondFragment())
                .addToBackStack(null)
                .commit()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Fragment Life Cycle Test","Fragment CreateView")
        return inflater.inflate(R.layout.fragment_login, container, false)
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

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
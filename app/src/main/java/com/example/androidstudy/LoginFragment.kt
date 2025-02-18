package com.example.androidstudy

import android.os.Bundle
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

        val loginButton = binding.loginButton
        val loginField = binding.loginField
        val passwordField = binding.passwordField

        loginButton.isEnabled = false

        passwordField.doOnTextChanged { text, start, before, count ->
            loginButton.isEnabled = (text?.length ?: 0) >= 8
            //хорошо, что прислушался к использованию doOnTextChanged.
            //Постарайся почитать про inline fun, очень полезная штука для оптимизации кода.
            //Вот как выглядит метод doOnTextChanged:
//            public inline fun TextView.doOnTextChanged(
//                crossinline action: (text: CharSequence?, start: Int, before: Int, count: Int) -> Unit
//            ): TextWatcher
            //Если не поймёшь - я объясню в следующий раз
        }

        loginButton.setOnClickListener(){
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_сontainer,SpinnerAndListViewFragment())
                .addToBackStack(null)
                .commit()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

}
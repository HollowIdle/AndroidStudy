package com.example.androidstudy.ui.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor (

) : ViewModel() {

    private val _isLoginButtonEnabled = MutableLiveData(false)
    val isLoginButtonEnabled : LiveData<Boolean> get() = _isLoginButtonEnabled

    fun onPasswordChanged(password: String){
        _isLoginButtonEnabled.value = password.length >= 8
    }

}
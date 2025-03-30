package com.example.androidstudy.ui.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidstudy.ui.domain.models.DomainPost
import com.example.androidstudy.ui.domain.use_cases.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor (
    private val getPostsUseCase : GetPostsUseCase
) : ViewModel() {

    private val _newsList = MutableLiveData<List<DomainPost>>()
    val newsList: LiveData<List<DomainPost>> = _newsList

    init {
        viewModelScope.launch {
            loadNews()
        }
    }

    private suspend fun loadNews(){
        _newsList.value = getPostsUseCase.getPosts()
    }

}
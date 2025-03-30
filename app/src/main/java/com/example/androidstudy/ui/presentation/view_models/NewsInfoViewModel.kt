package com.example.androidstudy.ui.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidstudy.ui.domain.models.DomainPost
import com.example.androidstudy.ui.domain.use_cases.GetPostInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsInfoViewModel @Inject constructor (
    private val getPostsInfoUseCase: GetPostInfoUseCase
) : ViewModel() {

    private val _postInfo = MutableLiveData<DomainPost>()
    val postInfo : LiveData<DomainPost> = _postInfo

    init{
        getPostInfo()
    }


    private fun getPostInfo(){
        //_postInfo.value = getPostsInfoUseCase.getPostInfo();
    }


}
package com.leo.retrofitrecyclerview.ui.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leo.retrofitrecyclerview.model.post.PostData
import com.leo.retrofitrecyclerview.network.NetworkService
import com.leo.retrofitrecyclerview.repository.Repository
import kotlinx.coroutines.launch

class UserPostViewModel():ViewModel() {

    private val repo = Repository(NetworkService())

    private val _postData = MutableLiveData<PostData>()
    val postData: LiveData<PostData> = _postData


    fun getPostById(userId: Int){
        viewModelScope.launch {
            _postData.value = repo.getPostByUserId(userId).body()
        }
    }

}
package com.leo.retrofitrecyclerview.ui.home

import androidx.lifecycle.*
import com.leo.retrofitrecyclerview.model.user.UserData
import com.leo.retrofitrecyclerview.network.NetworkService
import com.leo.retrofitrecyclerview.repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel(): ViewModel() {


    private val repo = Repository(NetworkService())

    private val _userData = MutableLiveData<UserData>()
    val userData: LiveData<UserData> =  _userData.asFlow().asLiveData()

    private fun getUser(){
        viewModelScope.launch {
            _userData.value = repo.getUser().body()
        }
    }
    init {
        getUser()
    }

}
package com.leo.retrofitrecyclerview.repository

import com.leo.retrofitrecyclerview.model.post.PostData
import com.leo.retrofitrecyclerview.model.user.UserData
import com.leo.retrofitrecyclerview.network.NetworkService
import retrofit2.Response

class Repository(private val service: NetworkService) {

    suspend fun getUser(): Response<UserData>{
        return service.retrofit().requestGetAsync()
    }

    suspend fun getPostByUserId(userId: Int):Response<PostData>{
        return service.retrofit().getPostByUserId(userId)
    }

}
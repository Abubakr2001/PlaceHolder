package com.leo.retrofitrecyclerview.network

import com.leo.retrofitrecyclerview.model.post.PostData
import com.leo.retrofitrecyclerview.model.user.UserData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface RequestService {

    @GET(Api.users)
   suspend fun requestGetAsync(): Response<UserData>


   @GET(Api.posts)
   suspend fun getPostByUserId(
       @Query("userId") query: Int
   ) :Response<PostData>

}
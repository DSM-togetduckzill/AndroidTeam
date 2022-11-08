package com.example.data.remote.api

import com.example.data.remote.request.FriendListRequest
import retrofit2.http.GET

interface FriendListAPI {

//    @GET("")
//    suspend fun getFriendList(
//    ): FriendListRequest

    suspend fun getFriendList(): FriendListRequest
}
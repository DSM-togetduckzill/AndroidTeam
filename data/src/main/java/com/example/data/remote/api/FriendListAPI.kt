package com.example.data.remote.api

import com.example.data.remote.response.FriendListResponse
import retrofit2.http.GET

interface FriendListAPI {

    @GET("")
    suspend fun getFriendList(
    ): FriendListResponse

   // suspend fun getFriendList(): FriendListResponse
}
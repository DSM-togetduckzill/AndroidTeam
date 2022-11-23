package com.example.data.remote.api

import com.example.data.remote.response.MyPageResponse
import retrofit2.http.GET

interface MyPageAPI {
    @GET ("user/mypage")
    suspend fun loadMyPage():MyPageResponse
}
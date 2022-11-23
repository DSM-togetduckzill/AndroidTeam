package com.example.data.remote.api

import com.example.data.remote.request.SignInRequest
import com.example.data.remote.response.TokenResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInAPI {

    @POST("user/login")
    suspend fun signIn(
        @Body signInRequest: SignInRequest
    ): TokenResponse
}
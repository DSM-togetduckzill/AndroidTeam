package com.example.data.remote.api

import com.example.data.remote.request.SignInRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInAPI {

    @POST("")
    suspend fun signIn(
        @Body signInRequest: SignInRequest
    )
}
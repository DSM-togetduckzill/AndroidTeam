package com.example.data.interceptor

import com.example.data.local.preference.SignInPreference
import kotlinx.coroutines.runBlocking
import okhttp3.*
import javax.inject.Inject

class AuthorizationInterceptor @Inject constructor(
    private val signInPreference: SignInPreference
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val path = request.url.encodedPath
        val method = request.method
        val ignorePath = listOf(
            "/user/login"
        )
        if (ignorePath.contains(path)) return chain.proceed(request)
        else if (path == "/users" && method == "POST") return chain.proceed(request)

        val accessToken = runBlocking { signInPreference.fetchAccessToken() }
        return chain.proceed(
            request.newBuilder().addHeader(
                "Authorization",
                "Bearer $accessToken"
            ).build()
        )
    }
}
package com.example.data.remote.request

import com.example.domain.entity.SignInEntity

data class SignInRequest(
    val id: String,
    val password: String
)

fun SignInEntity.toRequest() = SignInRequest(
    id = id,
    password = password
)

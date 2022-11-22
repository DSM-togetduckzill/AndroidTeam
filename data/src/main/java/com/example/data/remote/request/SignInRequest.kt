package com.example.data.remote.request

import com.example.domain.entity.SignInEntity
import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("account_id") val id: String,
    @SerializedName("password") val password: String
)

fun SignInEntity.toRequest() = SignInRequest(
    id = id,
    password = password
)

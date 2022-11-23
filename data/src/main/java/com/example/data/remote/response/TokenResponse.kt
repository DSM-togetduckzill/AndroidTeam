package com.example.data.remote.response

import com.example.domain.entity.TokenEntity
import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("access_token") val access_token: String
)

fun TokenResponse.toEntity() = TokenEntity(
    access_token = access_token
)

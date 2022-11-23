package com.example.data.remote.datasource

import com.example.domain.entity.SignInEntity
import com.example.domain.entity.TokenEntity

interface RemoteSignInDataSource {
    suspend fun signIn(signInEntity: SignInEntity): TokenEntity

    suspend fun changeSignIn(signInEntity: SignInEntity)
}
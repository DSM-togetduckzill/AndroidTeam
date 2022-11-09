package com.example.data.remote.datasource

import com.example.domain.entity.SignInEntity

interface RemoteSignInDataSource {
    suspend fun signIn(signInEntity: SignInEntity)

    suspend fun changeSignIn(signInEntity: SignInEntity)
}
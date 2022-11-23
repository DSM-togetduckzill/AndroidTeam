package com.example.data.local.datasource

import com.example.domain.entity.SignInEntity
import com.example.domain.entity.TokenEntity

interface LocalSignInDataSource {

    suspend fun saveToken(tokenEntity: TokenEntity)

    suspend fun autoSignIn(): SignInEntity

    suspend fun saveAutoSignIn(signInEntity: SignInEntity)

    suspend fun changeAutoSignIn(signInEntity: SignInEntity)

    suspend fun deleteAutoSignIn()
}
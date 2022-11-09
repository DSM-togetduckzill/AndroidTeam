package com.example.data.local.datasource

import com.example.domain.entity.SignInEntity

interface LocalSignInDataSource {

    suspend fun autoSignIn(): SignInEntity

    suspend fun saveAutoSignIn(signInEntity: SignInEntity)

    suspend fun changeAutoSignIn(signInEntity: SignInEntity)

    suspend fun deleteAutoSignIn()
}
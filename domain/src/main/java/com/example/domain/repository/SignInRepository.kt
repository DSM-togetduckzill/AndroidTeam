package com.example.domain.repository

import com.example.domain.entity.SignInEntity

interface SignInRepository {

    suspend fun signIn(signInEntity: SignInEntity)

    suspend fun autoSignIn()

    suspend fun saveAutoSignIn(signInEntity: SignInEntity)

    suspend fun changeAutoSignIn(signInEntity: SignInEntity)

    suspend fun deleteAutoSignIn()
}
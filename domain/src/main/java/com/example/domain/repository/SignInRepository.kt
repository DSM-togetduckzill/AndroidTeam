package com.example.domain.repository

import com.example.domain.entity.SignInEntity

interface SignInRepository {

    suspend fun signIn(signInEntity: SignInEntity)

    suspend fun saveAutoSignIn(signInEntity: SignInEntity)

    suspend fun fetchAutoSignIn(signInEntity: SignInEntity)

    suspend fun deleteAutoSignIn()
}
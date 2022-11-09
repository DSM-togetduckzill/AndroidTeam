package com.example.data.local.preference

interface SignInPreference {

    suspend fun fetchId(): String
    suspend fun fetchPassword(): String

    suspend fun saveId(id: String)
    suspend fun savePassword(password: String)

    suspend fun deleteSignIn()
}
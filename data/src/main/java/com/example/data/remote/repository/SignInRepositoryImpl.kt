package com.example.data.remote.repository

import android.util.Log
import com.example.data.local.datasource.LocalSignInDataSource
import com.example.data.remote.datasource.RemoteSignInDataSource
import com.example.domain.entity.SignInEntity
import com.example.domain.repository.SignInRepository
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val remoteSignInDataSource: RemoteSignInDataSource,
    private val localSignInDataSource: LocalSignInDataSource
): SignInRepository {
    override suspend fun signIn(signInEntity: SignInEntity) {
        val tokenEntity= remoteSignInDataSource.signIn(signInEntity)
        localSignInDataSource.saveToken(tokenEntity)
    }

    override suspend fun autoSignIn() {
        remoteSignInDataSource.signIn(localSignInDataSource.autoSignIn())
    }

    override suspend fun saveAutoSignIn(signInEntity: SignInEntity) =
        localSignInDataSource.saveAutoSignIn(signInEntity)

    override suspend fun changeAutoSignIn(signInEntity: SignInEntity){
        remoteSignInDataSource.changeSignIn(signInEntity)
        localSignInDataSource.changeAutoSignIn(signInEntity)
    }

    override suspend fun deleteAutoSignIn() {
        localSignInDataSource.deleteAutoSignIn()
    }
}
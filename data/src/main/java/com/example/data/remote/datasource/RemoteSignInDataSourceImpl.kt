package com.example.data.remote.datasource

import com.example.data.remote.api.SignInAPI
import com.example.data.remote.error.ErrorHandler
import com.example.data.remote.request.toRequest
import com.example.domain.entity.SignInEntity
import javax.inject.Inject

class RemoteSignInDataSourceImpl @Inject constructor(
    private val signInAPI: SignInAPI,
    private val errorHandler: ErrorHandler
):RemoteSignInDataSource {
    override suspend fun signIn(signInEntity: SignInEntity) =
        try{
            signInAPI.signIn(signInEntity.toRequest())
        }catch (e: Throwable){
            throw errorHandler.gerError(e)
        }

    override suspend fun changeSignIn(signInEntity: SignInEntity) {
    }
}
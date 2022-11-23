package com.example.data.remote.datasource

import com.example.data.remote.api.SignInAPI
import com.example.data.remote.request.toRequest
import com.example.data.remote.response.toEntity
import com.example.domain.entity.SignInEntity
import javax.inject.Inject

class RemoteSignInDataSourceImpl @Inject constructor(
    private val signInAPI: SignInAPI
):RemoteSignInDataSource {
    override suspend fun signIn(signInEntity: SignInEntity) =
        signInAPI.signIn(signInEntity.toRequest()).toEntity()

    override suspend fun changeSignIn(signInEntity: SignInEntity) {
    }
}
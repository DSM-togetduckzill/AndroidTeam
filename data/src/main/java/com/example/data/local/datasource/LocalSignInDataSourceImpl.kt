package com.example.data.local.datasource

import com.example.data.local.preference.SignInPreference
import com.example.domain.entity.SignInEntity
import javax.inject.Inject

class LocalSignInDataSourceImpl @Inject constructor(
    private val signInPreference: SignInPreference
): LocalSignInDataSource {
    override suspend fun autoSignIn(): SignInEntity =
        with(signInPreference){
            SignInEntity(
                id = fetchId(),
                password = fetchPassword()
            )
        }

    override suspend fun saveAutoSignIn(signInEntity: SignInEntity) {
        with(signInPreference){
            saveId(signInEntity.id)
            savePassword(signInEntity.password)
        }
    }

    override suspend fun changeAutoSignIn(signInEntity: SignInEntity) {
        with(signInPreference){
            saveId(signInEntity.id)
            savePassword(signInEntity.password)
        }
    }

    override suspend fun deleteAutoSignIn() {
        signInPreference.deleteSignIn()
    }
}
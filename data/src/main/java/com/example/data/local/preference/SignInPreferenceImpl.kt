package com.example.data.local.preference

import com.example.data.local.preference.util.SharedPreferenceHelper
import javax.inject.Inject

class SignInPreferenceImpl @Inject constructor(
    private val s: SharedPreferenceHelper
): SignInPreference {

    override suspend fun fetchId(): String =
        s.fetchStringPreference(ID)

    override suspend fun fetchPassword(): String =
        s.fetchStringPreference(PASSWORD)

    override suspend fun saveId(id: String) =
        s.saveStringPreference(ID,id)

    override suspend fun savePassword(password: String) =
        s.saveStringPreference(PASSWORD,password)

    override suspend fun deleteSignIn() {
        s.clearPreference(ID)
        s.clearPreference(PASSWORD)
    }

    companion object Key {
        const val ID = "ID"
        const val PASSWORD = "PASSWORD"
    }
}
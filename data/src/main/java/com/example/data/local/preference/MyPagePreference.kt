package com.example.data.local.preference

interface MyPagePreference {
    suspend fun saveName(name: String)
    suspend fun fetchName(): String

    suspend fun saveIntroduce(introduce: String)
    suspend fun fetchIntroduce(): String

    suspend fun saveBirthday(birthday: String)
    suspend fun fetchBirthday(): String

    suspend fun savePhonenumber(phonenumber: String)
    suspend fun fetchPhonenumber(): String

    suspend fun saveProfileimage(profileimage: String)
    suspend fun fetchProfileimage(): String
}
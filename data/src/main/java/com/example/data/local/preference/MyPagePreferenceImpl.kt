package com.example.data.local.preference

import android.content.SharedPreferences
import com.example.data.local.preference.util.SharedPreferenceHelper
import javax.inject.Inject

class MyPagePreferenceImpl @Inject constructor(
    private val s: SharedPreferenceHelper
): MyPagePreference {

    companion object Key {
        const val NAME = "NAME"
        const val INTRODUCE = "INTRODUCE"
        const val BIRTHDAY = "BIRTHDAT"
        const val PHONENUMBER = "PHONENUMBER"
        const val PROFILEIMAGE = "PROFILEIMAGE"
    }

    override suspend fun saveName(name: String) {
        s.saveStringPreference(NAME,name)
    }

    override suspend fun fetchName(): String =
        s.fetchStringPreference(NAME)

    override suspend fun saveIntroduce(introduce: String) {
        s.saveStringPreference(INTRODUCE,introduce)
    }

    override suspend fun fetchIntroduce(): String =
        s.fetchStringPreference(INTRODUCE)

    override suspend fun saveBirthday(birthday: String) {
        s.saveStringPreference(BIRTHDAY,birthday)
    }

    override suspend fun fetchBirthday(): String =
        s.fetchStringPreference(BIRTHDAY)

    override suspend fun savePhonenumber(phonenumber: String) {
        s.saveStringPreference(PHONENUMBER,phonenumber)
    }

    override suspend fun fetchPhonenumber(): String =
        s.fetchStringPreference(PHONENUMBER)

    override suspend fun saveProfileimage(profileimage: String) {
        s.saveStringPreference(PROFILEIMAGE,profileimage)
    }

    override suspend fun fetchProfileimage(): String =
        s.fetchStringPreference(PROFILEIMAGE)
}
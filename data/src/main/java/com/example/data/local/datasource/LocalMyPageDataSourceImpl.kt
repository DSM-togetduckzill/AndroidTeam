package com.example.data.local.datasource

import com.example.data.local.preference.MyPagePreference
import com.example.domain.entity.MyPageEntity
import javax.inject.Inject

class LocalMyPageDataSourceImpl @Inject constructor(
    private val myPagePreference: MyPagePreference
): LocalMyPageDataSource {
    override suspend fun loadMypageLocal(): MyPageEntity =
        with(myPagePreference) {
            MyPageEntity(
                name = fetchName(),
                introduce = fetchIntroduce(),
                birthday = fetchBirthday(),
                phone_number = fetchPhonenumber(),
                profile_image = fetchProfileimage()
            )
        }

    override suspend fun saveMyPage(myPageEntity: MyPageEntity) {
        with(myPagePreference){
            saveName(myPageEntity.name)
            saveIntroduce(myPageEntity.introduce)
            saveBirthday(myPageEntity.birthday)
            savePhonenumber(myPageEntity.phone_number)
            saveProfileimage(myPageEntity.profile_image)
        }
    }
}
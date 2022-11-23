package com.example.data.local.datasource

import com.example.domain.entity.MyPageEntity

interface LocalMyPageDataSource {
    suspend fun loadMypageLocal(): MyPageEntity

    suspend fun saveMyPage(myPageEntity: MyPageEntity)
}
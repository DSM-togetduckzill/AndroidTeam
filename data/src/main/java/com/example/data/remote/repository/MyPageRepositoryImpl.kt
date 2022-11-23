package com.example.data.remote.repository

import com.example.data.local.datasource.LocalMyPageDataSource
import com.example.data.remote.datasource.RemoteMyPageDataSource
import com.example.domain.entity.MyPageEntity
import com.example.domain.repository.MyPageRepository
import javax.inject.Inject

class MyPageRepositoryImpl @Inject constructor(
    private val remoteMyPageDataSource: RemoteMyPageDataSource,
    private val localMyPageDataSource: LocalMyPageDataSource
): MyPageRepository{
    override suspend fun lodeMyPage(): MyPageEntity {
        val myPageEntity = remoteMyPageDataSource.lodeMyPage()
        localMyPageDataSource.saveMyPage(myPageEntity)
        return myPageEntity
    }

    override suspend fun loadMyPageLocal(): MyPageEntity = localMyPageDataSource.loadMypageLocal()

}
package com.example.data.remote.datasource

import com.example.data.remote.api.MyPageAPI
import com.example.data.remote.response.toEntity
import com.example.domain.entity.MyPageEntity
import javax.inject.Inject

class RemoteMyPageDataSourceImpl @Inject constructor(
    private val myPageAPI: MyPageAPI
): RemoteMyPageDataSource{
    override suspend fun lodeMyPage(): MyPageEntity = myPageAPI.loadMyPage().toEntity()
}
package com.example.data.remote.datasource

import com.example.domain.entity.MyPageEntity

interface RemoteMyPageDataSource {
    suspend fun lodeMyPage(): MyPageEntity
}
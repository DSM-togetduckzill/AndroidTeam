package com.example.domain.repository

import com.example.domain.entity.MyPageEntity

interface MyPageRepository {
    suspend fun lodeMyPage():MyPageEntity

    suspend fun loadMyPageLocal(): MyPageEntity
}
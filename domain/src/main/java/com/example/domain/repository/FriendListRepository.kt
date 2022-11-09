package com.example.domain.repository

import com.example.domain.param.FriendListParam

interface FriendListRepository {
    suspend fun getFriendList(): FriendListParam
}
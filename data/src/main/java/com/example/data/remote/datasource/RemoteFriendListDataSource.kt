package com.example.data.remote.datasource

import com.example.domain.param.FriendListParam

interface RemoteFriendListDataSource {
    suspend fun getFriendList(): FriendListParam
}
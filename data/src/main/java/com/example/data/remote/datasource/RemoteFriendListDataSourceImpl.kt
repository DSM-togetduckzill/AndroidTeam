package com.example.data.remote.datasource

import com.example.data.remote.api.FriendListAPI
import com.example.data.remote.response.toParam
import com.example.domain.param.FriendListParam
import javax.inject.Inject

class RemoteFriendListDataSourceImpl @Inject constructor(
    private val friendListAPI: FriendListAPI,
): RemoteFriendListDataSource {
    override suspend fun getFriendList(): FriendListParam = friendListAPI.getFriendList().toParam()
}
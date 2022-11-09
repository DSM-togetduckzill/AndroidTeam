package com.example.data.remote.datasource

import com.example.data.remote.api.FriendListAPI
import com.example.data.remote.error.ErrorHandler
import com.example.data.remote.response.toParam
import com.example.domain.param.FriendListParam
import javax.inject.Inject

class RemoteFriendListDataSourceImpl @Inject constructor(
    private val friendListAPI: FriendListAPI,
    private val errorHandler: ErrorHandler
): RemoteFriendListDataSource {
    override suspend fun getFriendList(): FriendListParam =
        try {
            friendListAPI.getFriendList().toParam()
        } catch (e: Throwable) {
            throw errorHandler.gerError(e)
        }
}
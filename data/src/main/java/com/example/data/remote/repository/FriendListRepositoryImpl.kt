package com.example.data.remote.repository

import com.example.data.remote.datasource.RemoteFriendListDataSource
import com.example.domain.param.FriendListParam
import com.example.domain.repository.FriendListRepository
import javax.inject.Inject

class FriendListRepositoryImpl @Inject constructor(
    private val remoteFriendListDataSource: RemoteFriendListDataSource
): FriendListRepository {
    override suspend fun getFriendList(): FriendListParam =
        remoteFriendListDataSource.getFriendList()
}
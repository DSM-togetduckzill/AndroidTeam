package com.example.data.remote.api

import com.example.data.remote.request.FriendListRequest
import javax.inject.Inject

class FriendListAPITest @Inject constructor(): FriendListAPI{

    override suspend fun getFriendList(): FriendListRequest {
        return FriendListRequest(
            index = 0,
            imageUrl = null,
            title = "제목",
            content = "본문"
        )
    }
}
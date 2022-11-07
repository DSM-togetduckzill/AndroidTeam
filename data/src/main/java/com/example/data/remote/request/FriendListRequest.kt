package com.example.data.remote.request

import com.example.domain.param.FriendListParam

data class FriendListRequest(
    val index: Int,
    val imageUrl: String?,
    val title: String,
    val content: String,
)

fun FriendListRequest.toParam() = FriendListParam(
    index = index,
    imageUrl = imageUrl,
    title = title,
    content = content
)
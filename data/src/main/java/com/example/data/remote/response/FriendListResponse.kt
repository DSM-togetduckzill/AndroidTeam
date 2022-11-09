package com.example.data.remote.response

import com.example.domain.param.FriendListParam

data class FriendListResponse(
    val index: Int,
    val imageUrl: String?,
    val title: String,
    val content: String,
)

fun FriendListResponse.toParam() = FriendListParam(
    index = index,
    imageUrl = imageUrl,
    title = title,
    content = content
)
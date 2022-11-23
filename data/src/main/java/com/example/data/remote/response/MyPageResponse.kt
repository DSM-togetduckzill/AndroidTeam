package com.example.data.remote.response

import com.example.domain.entity.MyPageEntity

data class MyPageResponse (
    val name: String,
    val introduce: String,
    val birthday : String,
    val phone_number: String,
    val profile_image : String
)

fun MyPageResponse.toEntity() = MyPageEntity(
    name = name,
    introduce = introduce,
    birthday = birthday,
    phone_number = phone_number,
    profile_image = profile_image
)

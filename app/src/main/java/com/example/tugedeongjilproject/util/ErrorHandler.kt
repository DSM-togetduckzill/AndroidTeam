package com.example.tugedeongjilproject.util

fun basicErrorHandler(error: String): String =
    when(error) {
        "HTTP 400"  -> "모든 항목이 입력되었는지 확인해주세요."
        else -> "알 수 없는 오류입니다."
    }
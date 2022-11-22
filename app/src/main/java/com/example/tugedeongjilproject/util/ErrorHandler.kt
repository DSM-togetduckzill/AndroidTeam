package com.example.tugedeongjilproject.util


fun basicErrorHandler(error: String): String =
    when(error) {
        E.HTTP400  -> "모든 항목이 입력되었는지 확인해주세요."
        else -> "알 수 없는 오류입니다."
    }

fun loginErrorHandler(error: String): String =
    when(error) {
        E.HTTP400 -> "아이디 비밀번호를 모두 입력해 주세요"
        E.HTTP401 -> "아이디 또는 비밀번호가 잘못되었습니다"
        E.HTTP500 -> E.HTTP500_T
        else -> E.ELSE_T
    }

object E{
    const val HTTP400 = "HTTP 400"
    const val HTTP401 = "HTTP 401"
    const val HTTP500 = "HTTP 500"
    const val HTTP500_T = "서버가 닫혀있습니다"
    const val ELSE_T = "알 수 없는 오류입니다."
}
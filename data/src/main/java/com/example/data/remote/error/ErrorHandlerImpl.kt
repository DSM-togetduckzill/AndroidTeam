package com.example.data.remote.error

import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ErrorHandlerImpl: ErrorHandler {
    override suspend fun gerError(throwable: Throwable): ErrorHandlerEntity = when (throwable) {
        is HttpException -> when (throwable.code()) {
            422 -> ErrorHandlerEntity(sendMessage = "입력오류")
            401 -> ErrorHandlerEntity(sendMessage = "토큰오류")
            404 -> ErrorHandlerEntity(sendMessage = "토큰을 찾을 수 없음")
            405 -> ErrorHandlerEntity(sendMessage = "메소드 오류")
            else -> ErrorHandlerEntity(sendMessage = "알 수 없는 오류가 발생했습니다")
        }
        is ConnectException -> ErrorHandlerEntity(sendMessage = "인터넷 연결이 되지 않았습니다")
        is SocketTimeoutException -> ErrorHandlerEntity(sendMessage = "인터넷 연결이 불안정합니다")
        is UnknownHostException -> ErrorHandlerEntity(sendMessage = "인터넷 연결이 되지 않았습니다")
        else -> {
            ErrorHandlerEntity("Unknown")
        }
    }
}
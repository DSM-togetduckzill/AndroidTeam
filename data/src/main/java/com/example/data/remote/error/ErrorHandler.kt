package com.example.data.remote.error

interface ErrorHandler {
    suspend fun gerError(throwable: Throwable): ErrorHandlerEntity
}
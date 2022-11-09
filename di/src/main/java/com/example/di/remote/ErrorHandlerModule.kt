package com.example.di.remote

import com.example.data.remote.error.ErrorHandler
import com.example.data.remote.error.ErrorHandlerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ErrorHandlerModule {

    @Singleton
    @Provides
    fun errorHandler(): ErrorHandler = ErrorHandlerImpl()
}
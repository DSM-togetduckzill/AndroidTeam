package com.example.di.remote

import com.example.data.remote.api.FriendListAPI
import com.example.data.remote.datasource.RemoteFriendListDataSource
import com.example.data.remote.datasource.RemoteFriendListDataSourceImpl
import com.example.data.remote.error.ErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    @Singleton
    @Provides
    fun bindRemoteFriendListDataModule(
        friendListAPI: FriendListAPI,
        errorHandler: ErrorHandler
    ): RemoteFriendListDataSource = RemoteFriendListDataSourceImpl(friendListAPI,errorHandler)
}
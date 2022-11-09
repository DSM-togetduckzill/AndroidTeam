package com.example.di.remote

import com.example.data.remote.api.FriendListAPI
import com.example.data.remote.api.FriendListAPITest
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ApiTestModule {

    @Binds
    abstract fun bindFriendListAPITest(
        friendListAPITest: FriendListAPITest
    ): FriendListAPI
}
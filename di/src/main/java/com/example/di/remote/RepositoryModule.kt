package com.example.di.remote

import com.example.data.remote.repository.FriendListRepositoryImpl
import com.example.domain.repository.FriendListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindFriendListRepository(
        friendListRepositoryImpl: FriendListRepositoryImpl
    ): FriendListRepository
}
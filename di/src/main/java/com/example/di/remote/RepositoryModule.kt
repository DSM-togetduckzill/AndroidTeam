package com.example.di.remote

import com.example.data.remote.repository.FriendListRepositoryImpl
import com.example.data.remote.repository.MyPageRepositoryImpl
import com.example.data.remote.repository.SignInRepositoryImpl
import com.example.domain.repository.FriendListRepository
import com.example.domain.repository.MyPageRepository
import com.example.domain.repository.SignInRepository
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

    @Binds
    abstract fun bindSignInRepository(
        signInRepositoryImpl: SignInRepositoryImpl
    ): SignInRepository

    @Binds
    abstract fun bindMyPageRepository(
        myPageRepositoryImpl: MyPageRepositoryImpl
    ): MyPageRepository
}
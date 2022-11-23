package com.example.di.remote

import com.example.data.remote.api.FriendListAPI
import com.example.data.remote.api.MyPageAPI
import com.example.data.remote.api.SignInAPI
import com.example.data.remote.datasource.*
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
    ): RemoteFriendListDataSource = RemoteFriendListDataSourceImpl(friendListAPI)

    @Singleton
    @Provides
    fun bindRemoteSignInDataModule(
        signInAPI: SignInAPI,
    ): RemoteSignInDataSource = RemoteSignInDataSourceImpl(signInAPI)

    @Singleton
    @Provides
    fun bindRemoteMyPageDataModule(
        myPageAPI: MyPageAPI,
    ): RemoteMyPageDataSource = RemoteMyPageDataSourceImpl(myPageAPI)
}
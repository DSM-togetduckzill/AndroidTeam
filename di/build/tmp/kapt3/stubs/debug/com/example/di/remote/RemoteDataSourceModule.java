package com.example.di.remote;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/example/di/remote/RemoteDataSourceModule;", "", "()V", "bindRemoteFriendListDataModule", "Lcom/example/data/remote/datasource/RemoteFriendListDataSource;", "friendListAPI", "Lcom/example/data/remote/api/FriendListAPI;", "errorHandler", "Lcom/example/data/remote/error/ErrorHandler;", "di_debug"})
@dagger.Module()
public final class RemoteDataSourceModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.di.remote.RemoteDataSourceModule INSTANCE = null;
    
    private RemoteDataSourceModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.data.remote.datasource.RemoteFriendListDataSource bindRemoteFriendListDataModule(@org.jetbrains.annotations.NotNull()
    com.example.data.remote.api.FriendListAPI friendListAPI, @org.jetbrains.annotations.NotNull()
    com.example.data.remote.error.ErrorHandler errorHandler) {
        return null;
    }
}
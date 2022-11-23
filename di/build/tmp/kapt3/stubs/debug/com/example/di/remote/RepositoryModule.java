package com.example.di.remote;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\'\u00a8\u0006\u000f"}, d2 = {"Lcom/example/di/remote/RepositoryModule;", "", "()V", "bindFriendListRepository", "Lcom/example/domain/repository/FriendListRepository;", "friendListRepositoryImpl", "Lcom/example/data/remote/repository/FriendListRepositoryImpl;", "bindMyPageRepository", "Lcom/example/domain/repository/MyPageRepository;", "myPageRepositoryImpl", "Lcom/example/data/remote/repository/MyPageRepositoryImpl;", "bindSignInRepository", "Lcom/example/domain/repository/SignInRepository;", "signInRepositoryImpl", "Lcom/example/data/remote/repository/SignInRepositoryImpl;", "di_debug"})
@dagger.Module()
public abstract class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract com.example.domain.repository.FriendListRepository bindFriendListRepository(@org.jetbrains.annotations.NotNull()
    com.example.data.remote.repository.FriendListRepositoryImpl friendListRepositoryImpl);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract com.example.domain.repository.SignInRepository bindSignInRepository(@org.jetbrains.annotations.NotNull()
    com.example.data.remote.repository.SignInRepositoryImpl signInRepositoryImpl);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract com.example.domain.repository.MyPageRepository bindMyPageRepository(@org.jetbrains.annotations.NotNull()
    com.example.data.remote.repository.MyPageRepositoryImpl myPageRepositoryImpl);
}
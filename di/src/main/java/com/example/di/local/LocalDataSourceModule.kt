package com.example.di.local

import com.example.data.local.datasource.LocalMyPageDataSource
import com.example.data.local.datasource.LocalMyPageDataSourceImpl
import com.example.data.local.datasource.LocalSignInDataSource
import com.example.data.local.datasource.LocalSignInDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindLocalMyPageDataSource(
        localMyPageDataSourceImpl: LocalMyPageDataSourceImpl
    ): LocalMyPageDataSource

    @Binds
    abstract fun bindLocalSignInDataSource(
        localSignInDataSourceImpl: LocalSignInDataSourceImpl
    ): LocalSignInDataSource
}
package com.example.di.local

import com.example.data.local.preference.MyPagePreference
import com.example.data.local.preference.MyPagePreferenceImpl
import com.example.data.local.preference.SignInPreference
import com.example.data.local.preference.SignInPreferenceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PreferenceModule {

    @Binds
    abstract fun bindMyPagePreference(
        myPagePreferenceImpl: MyPagePreferenceImpl
    ): MyPagePreference

    @Binds
    abstract fun bindSignInPreference(
        signInPreferenceImpl: SignInPreferenceImpl
    ): SignInPreference
}
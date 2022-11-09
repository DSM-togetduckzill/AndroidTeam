package com.example.di.remote

import android.util.Log
import com.example.data.remote.api.FriendListAPI
import com.example.data.remote.api.SignInAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor{ Log.v("HTTP",it)}
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://34.209.138.0:8000/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

   @Singleton
   @Provides
   fun provideFriendListApi(
       retrofit: Retrofit
   ): FriendListAPI =
       retrofit.create(FriendListAPI::class.java)

    @Singleton
    @Provides
    fun provideSignInApi(
        retrofit: Retrofit
    ): SignInAPI =
        retrofit.create(SignInAPI::class.java)
}
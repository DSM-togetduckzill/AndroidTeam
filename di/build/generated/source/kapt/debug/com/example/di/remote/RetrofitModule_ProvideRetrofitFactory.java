// Generated by Dagger (https://dagger.dev).
package com.example.di.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RetrofitModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final Provider<OkHttpClient> okHttpClientProvider;

  public RetrofitModule_ProvideRetrofitFactory(Provider<OkHttpClient> okHttpClientProvider) {
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit(okHttpClientProvider.get());
  }

  public static RetrofitModule_ProvideRetrofitFactory create(
      Provider<OkHttpClient> okHttpClientProvider) {
    return new RetrofitModule_ProvideRetrofitFactory(okHttpClientProvider);
  }

  public static Retrofit provideRetrofit(OkHttpClient okHttpClient) {
    return Preconditions.checkNotNullFromProvides(RetrofitModule.INSTANCE.provideRetrofit(okHttpClient));
  }
}
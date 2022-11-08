// Generated by Dagger (https://dagger.dev).
package com.example.di.remote;

import com.example.data.remote.api.FriendListAPI;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RetrofitModule_ProvideFriendListApiFactory implements Factory<FriendListAPI> {
  private final Provider<Retrofit> retrofitProvider;

  public RetrofitModule_ProvideFriendListApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public FriendListAPI get() {
    return provideFriendListApi(retrofitProvider.get());
  }

  public static RetrofitModule_ProvideFriendListApiFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new RetrofitModule_ProvideFriendListApiFactory(retrofitProvider);
  }

  public static FriendListAPI provideFriendListApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(RetrofitModule.INSTANCE.provideFriendListApi(retrofit));
  }
}

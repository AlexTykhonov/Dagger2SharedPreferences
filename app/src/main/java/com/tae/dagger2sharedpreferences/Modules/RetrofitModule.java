package com.tae.dagger2sharedpreferences.Modules;

import com.tae.dagger2sharedpreferences.BbcInter;
import com.tae.dagger2sharedpreferences.Scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.tae.dagger2sharedpreferences.BbcInter.BASE_URL;

@Module
public class RetrofitModule {

    @Provides
    @ApplicationScope
  public BbcInter getApiInterface(Retrofit retrofit) {
      return retrofit.create(BbcInter.class);
    }

    @Provides
    @ApplicationScope
    Retrofit getRetrofit (OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @ApplicationScope
    OkHttpClient getOkHttpClient (HttpLoggingInterceptor httpLoggingInterceptor) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        return client;
    }

    @Provides
    @ApplicationScope
    HttpLoggingInterceptor getHttpLoginInterceptor () {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

}

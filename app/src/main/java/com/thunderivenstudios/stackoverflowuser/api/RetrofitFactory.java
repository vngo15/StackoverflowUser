package com.thunderivenstudios.stackoverflowuser.api;

import com.thunderivenstudios.stackoverflowuser.application.UserApplication;
import com.thunderivenstudios.stackoverflowuser.config.Config;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vincent Ngo on 9/17/2017.
 * ©Vincent Ngo. All rights reserved.
 */

public class RetrofitFactory {
    private RetrofitFactory() {}

    public static Retrofit getRetrofit(String endpointUrl) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Cache cache = new Cache(UserApplication.instance().getCacheDir(),
                Config.CACHE_SIZE);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .cache(cache)
                .build();
        return new Retrofit.Builder()
                .baseUrl(endpointUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}

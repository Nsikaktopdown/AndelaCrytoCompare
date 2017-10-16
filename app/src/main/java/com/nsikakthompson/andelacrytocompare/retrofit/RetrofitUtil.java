package com.nsikakthompson.andelacrytocompare.retrofit;

import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nsikak on 10/16/17.
 */

public class RetrofitUtil {

    Context context;

    public RetrofitUtil(Context context){
     this.context = context;
    }
    Cache provideHttpCache() {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(context.getCacheDir(), cacheSize);
        return cache;
    }

    public  OkHttpClient provideOkhttpClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(provideHttpCache());
        return client.build();
    }

    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

  public GsonConverterFactory provideGsonConverterFactory() {
        Gson gson = provideGson();
        return GsonConverterFactory.create(gson);
    }



   public  Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://min-api.cryptocompare.com/")
                .client(provideOkhttpClient())
                .addConverterFactory(provideGsonConverterFactory())
                .build();
    }

}

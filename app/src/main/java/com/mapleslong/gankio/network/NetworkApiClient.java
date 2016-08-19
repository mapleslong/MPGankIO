package com.mapleslong.gankio.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mapleslong.gankio.config.GankConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mapleslong on 16/8/17.
 */
public class NetworkApiClient {
    private static NetworkApiClient mInstance;
    private static ApiService mApi;

    public NetworkApiClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .retryOnConnectionFailure(true)
                .build();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .disableHtmlEscaping()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(GankConfig.API_URL)
                .build();
        mApi = retrofit.create(ApiService.class);
    }

    public static ApiService getApiService() {
        if (mInstance == null) {
            synchronized (NetworkApiClient.class) {
                if (mInstance == null) {
                    mInstance = new NetworkApiClient();
                }
            }
        }
        return mApi;
    }
}

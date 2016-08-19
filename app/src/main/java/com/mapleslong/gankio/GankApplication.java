package com.mapleslong.gankio;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Mapleslong on 16/8/17.
 */
public class GankApplication extends Application {
    private static GankApplication mInstance;
    private ExecutorService mThreadPool;

    public static GankApplication getInstance() {return mInstance;}


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        LeakCanary.install(this);
        mThreadPool = Executors.newFixedThreadPool(3);// 建立为队列3个的线程池
    }

    public ExecutorService getThreadPool() {
        return mThreadPool;
    }
}

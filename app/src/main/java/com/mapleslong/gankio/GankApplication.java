package com.mapleslong.gankio;

import android.app.Application;

/**
 * Created by Mapleslong on 16/8/17.
 */
public class GankApplication extends Application {
    private static GankApplication mInstance;

    public static GankApplication getInstance() {return mInstance;}


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
//        LeakCanary.install(this);
    }

}

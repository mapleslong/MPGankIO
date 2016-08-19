package com.mapleslong.gankio.utils;

import android.content.Context;
import android.os.Handler;

import com.mapleslong.mpprogresshud.MPProgressHUD;

/**
 * Created by Mapleslong on 16/6/21.
 */
public class HUDUtil {
    private static MPProgressHUD instance;

    public static MPProgressHUD getInstance() {
        return instance;
    }

    public static void showLoading(Context context) {
        instance = MPProgressHUD.create(context)
                .setLabel("请稍候...")
                .setCancellable(true)
                .setDimAmount(0.5f)
                .show();
    }

    public static void hideLoading() {
        if (instance != null) {
            if (instance.isShowing()) {
                instance.dismiss();
            }
        }
        instance = null;
    }

    public static void showMessage(Context context, String msg) {
        instance = MPProgressHUD.create(context)
                .setLabel(msg)
                .setCancellable(true)
                .setDimAmount(0.5f)
                .show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (instance != null) {
                    instance.dismiss();
                }
            }
        }, 1500);
    }


    public static void showDownload(Context context) {
        instance = MPProgressHUD.create(context)
                .setLabel("正在下载: 0%")
                .setCancellable(true)
                .setDimAmount(0.5f)
                .show();
    }

    public static void updateDownload(int progress) {
        if (instance != null) {
            instance.setLabel("正在下载: " + progress + "%");
        }
    }
}

package com.mapleslong.gankio.manager;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.LinkedList;

/**
 * Created by Mapleslong on 16/8/18.
 */
public class ActivityStackManager {
    private static LinkedList<Activity> mActivityStack;
    private static ActivityStackManager mInstance;

    public static ActivityStackManager getInstance() {
        if (mInstance == null) {
            synchronized (ActivityStackManager.class) {
                if (mInstance == null) {
                    mInstance = new ActivityStackManager();
                }
            }
        }
        return mInstance;
    }

    public void addActivity(Activity activity) {
        if (mActivityStack == null) {
            mActivityStack = new LinkedList<>();
        }
        mActivityStack.add(activity);
    }

    public Activity currentActivity() {
        Activity activity = mActivityStack.getLast();
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        Activity activity = mActivityStack.getLast();
        finishActivity(activity);
    }

    public void finishActivity(Activity activity) {
        if (activity != null) {
            if (mActivityStack != null) {
                mActivityStack.remove(activity);
            }
        }
        activity.finish();
        activity = null;
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : mActivityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = mActivityStack.size(); i < size; i++) {
            if (null != mActivityStack.get(i)) {
                mActivityStack.get(i).finish();
            }
        }
        mActivityStack.clear();
    }


    public void AppExit(Context context) {
        try {
            finishAllActivity();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context
                    .ACTIVITY_SERVICE);
            activityManager.restartPackage(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int ActivityStackSize() {
        return mActivityStack == null ? 0 : mActivityStack.size();
    }

}

package com.liuleshuai.common.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.multidex.MultiDex;

/**
 * Created by LiuKuo at 2018/3/21
 */

public abstract class BaseApplication extends Application {
    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
        initSDK();
    }

    /**
     * 使用模拟器时，退出APP调用
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    /**
     * 64k问题处理：分包
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    public static Context getAppContext() {
        return baseApplication;
    }

    public static Resources getAppResources() {
        return baseApplication.getResources();
    }

    /**
     * 在此进行SDK的初始化
     */
    public abstract void initSDK();
}

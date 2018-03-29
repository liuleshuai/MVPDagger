package com.liuleshuai.mvpdagger.di.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * 用于其他component依赖时，使用！！！
 * <p>
 * Created by LiuKuo at 2018/3/29
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    public Activity provideActivity() {
        return mActivity;
    }
}

package com.liuleshuai.mvpdagger.di.component;

import android.app.Activity;

import com.liuleshuai.mvpdagger.di.module.ActivityModule;
import com.liuleshuai.mvpdagger.di.scope.ActivityScope;
import com.liuleshuai.mvpdagger.ui.activity.MainActivity;
import com.liuleshuai.mvpdagger.ui.activity.SplashActivity;

import dagger.Component;

/**
 * Created by LiuKuo at 2018/3/29
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

    void inject(SplashActivity splashActivity);

    void inject(MainActivity mainActivity);
}

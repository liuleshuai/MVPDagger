package com.liuleshuai.mvpdagger.di.component;

import com.liuleshuai.mvpdagger.ui.activity.MainActivity;
import com.liuleshuai.mvpdagger.ui.activity.SplashActivity;

import dagger.Component;

/**
 * Created by LiuKuo at 2018/3/29
 */
@Component(dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(SplashActivity splashActivity);

    void inject(MainActivity mainActivity);
}

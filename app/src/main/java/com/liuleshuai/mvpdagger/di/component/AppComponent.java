package com.liuleshuai.mvpdagger.di.component;

import com.liuleshuai.mvpdagger.app.DataManager;
import com.liuleshuai.mvpdagger.app.MyApplication;
import com.liuleshuai.mvpdagger.di.module.AppModule;
import com.liuleshuai.mvpdagger.di.module.HttpModule;
import com.liuleshuai.mvpdagger.http.RetrofitHelper;
import com.liuleshuai.mvpdagger.preference.PreferenceHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by LiuKuo at 2018/3/29
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    /**
     * 提供App的Context
     *
     * @return GeeksApp context
     */
    MyApplication getMyApplication();

    /**
     * 提供http的帮助类
     *
     * @return RetrofitHelper
     */
    RetrofitHelper getRetrofit();

    /**
     * 提供sp帮助类
     *
     * @return PreferenceHelperImpl
     */
    PreferenceHelper getPreference();

    /**
     * 数据中心
     *
     * @return DataManager
     */
    DataManager getDataManager();
}

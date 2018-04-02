package com.liuleshuai.mvpdagger.di.module;

import com.liuleshuai.mvpdagger.app.DataManager;
import com.liuleshuai.mvpdagger.http.HttpHelper;
import com.liuleshuai.mvpdagger.http.RetrofitHelper;
import com.liuleshuai.mvpdagger.preference.PreferenceHelper;
import com.liuleshuai.mvpdagger.preference.PreferenceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by LiuKuo at 2018/3/29
 */
@Module
public class AppModule {

    @Singleton
    @Provides
    DataManager provideDataManager(HttpHelper httpHelper, PreferenceImpl preference) {
        return new DataManager(httpHelper, preference);
    }

    @Singleton
    @Provides
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Singleton
    @Provides
    PreferenceImpl providePreference(PreferenceHelper preferenceHelper) {
        return preferenceHelper;
    }

}

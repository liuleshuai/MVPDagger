package com.liuleshuai.mvpdagger.app;

import com.liuleshuai.mvpdagger.bean.MovieEntity;
import com.liuleshuai.mvpdagger.http.HttpHelper;
import com.liuleshuai.mvpdagger.preference.PreferenceImpl;

import io.reactivex.Flowable;

/**
 * Created by LiuKuo at 2018/3/29
 */

public class DataManager implements HttpHelper, PreferenceImpl {
    private HttpHelper mHttpHelper;
    private PreferenceImpl mPreferenceHelper;

    public DataManager(HttpHelper mHttpHelper, PreferenceImpl mPreferenceHelper) {
        this.mHttpHelper = mHttpHelper;
        this.mPreferenceHelper = mPreferenceHelper;
    }

    @Override
    public Flowable<MovieEntity> getMovieTop(int start, int count) {
        return mHttpHelper.getMovieTop(start, count);
    }

    @Override
    public void setLoginAccount(String account) {
        mPreferenceHelper.setLoginAccount(account);
    }

    @Override
    public String getLoginAccount() {
        return mPreferenceHelper.getLoginAccount();
    }

    @Override
    public void setLoginStatus(boolean isLogin) {
        mPreferenceHelper.setLoginStatus(isLogin);
    }

    @Override
    public boolean getLoginStatus() {
        return mPreferenceHelper.getLoginStatus();
    }
}

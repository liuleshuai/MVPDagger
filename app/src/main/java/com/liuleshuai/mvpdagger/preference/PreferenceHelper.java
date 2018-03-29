package com.liuleshuai.mvpdagger.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.liuleshuai.mvpdagger.app.Constants;
import com.liuleshuai.mvpdagger.app.MyApplication;

/**
 * Created by LiuKuo at 2018/3/29
 */

public class PreferenceHelper implements PreferenceImpl {
    private static final String APP_SHARE = "app_preference";
    private final SharedPreferences mPreferences;

    public PreferenceHelper() {
        mPreferences = MyApplication.getAppContext().getSharedPreferences(APP_SHARE, Context.MODE_PRIVATE);
    }

    @Override
    public void setLoginAccount(String account) {
        mPreferences.edit().putString(Constants.ACCOUNT, account).apply();
    }

    @Override
    public String getLoginAccount() {
        return mPreferences.getString(Constants.ACCOUNT, "");
    }

    @Override
    public void setLoginStatus(boolean isLogin) {
        mPreferences.edit().putBoolean(Constants.LOGIN_STATUS, isLogin).apply();
    }

    @Override
    public boolean getLoginStatus() {
        return mPreferences.getBoolean(Constants.LOGIN_STATUS, false);
    }
}

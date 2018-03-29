package com.liuleshuai.mvpdagger.preference;

/**
 * Created by LiuKuo at 2018/3/29
 */

public interface PreferenceImpl {
    /**
     * Set login account
     *
     * @param account Account
     */
    void setLoginAccount(String account);

    /**
     * Get login account
     *
     * @return account
     */
    String getLoginAccount();

    /**
     * Set login status
     *
     * @param isLogin IsLogin
     */
    void setLoginStatus(boolean isLogin);

    /**
     * Get login status
     *
     * @return login status
     */
    boolean getLoginStatus();
}

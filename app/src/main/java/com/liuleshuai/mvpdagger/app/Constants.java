package com.liuleshuai.mvpdagger.app;

import java.io.File;

/**
 * Created by LiuKuo at 2018/3/22
 */

public class Constants {

    public static final String MOVIE_URL = "https://api.douban.com/v2/movie/";
    public static final String WAN_ANDROID_URL = "http://www.wanandroid.com/";

    /**
     * Path
     */
    public static final String PATH_DATA = MyApplication.getAppContext().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    /**
     * tag fragment classify
     */
    public static final int FIRST = 0;

    public static final int SECOND = 1;

    public static final int THIRD = 2;

    public static final int FOURTH = 3;

    /**
     * 界面传递参数标识
     */
    public static final String ARG_PARAM1 = "param1";

    public static final String ARG_PARAM2 = "param2";

    /**
     * Shared Preference key
     */
    public static final String ACCOUNT = "account";

    public static final String LOGIN_STATUS = "login_status";

    /**
     * OkHttp设置
     */
    public static final int CONNECT_TIMEOUT = 10;
    public static final int READ_TIMEOUT = 10;
    public static final int WRITE_TIMEOUT = 10;

}

package com.liuleshuai.mvpdagger.app;

import com.alibaba.android.arouter.launcher.ARouter;
import com.liuleshuai.common.base.BaseApplication;
import com.liuleshuai.mvpdagger.BuildConfig;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * Created by LiuKuo at 2018/3/22
 */

public class MyApplication extends BaseApplication {
    private String tag = "LK";

    @Override
    public void initSDK() {
        initARouter();
        initLogger();
    }

    /**
     * 这两行必须写在init之前，否则这些配置在init过程中将无效
     */
    private void initARouter() {
        if (BuildConfig.LOG_DEBUG) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);
    }

    /**
     * 初始化Logger
     */
    private void initLogger() {
        //DEBUG版本才打控制台log
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(new AndroidLogAdapter(PrettyFormatStrategy.newBuilder().
                    tag(tag).build()));
        }
    }
}

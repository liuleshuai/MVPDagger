package com.example.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.common.tools.ActivityManager;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by LiuKuo at 2018/3/21
 */

public abstract class BaseActivity<T extends BasePresenter> extends SupportActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        onViewCreated();
        ActivityManager.getInstance().addActivity(this);
        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().removeActivity();
    }

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();


    /**
     * 布局资源初始化
     */
    protected void onViewCreated() {
    }

    /**
     * 初始化事件、数据
     */
    protected abstract void initEventAndData();
}

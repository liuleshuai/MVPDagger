package com.example.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.common.tools.ActivityManager;

import javax.inject.Inject;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by LiuKuo at 2018/3/21
 */

public abstract class BaseActivity<T extends BasePresenter> extends SupportActivity implements BaseView {
    @Inject
    protected T mPresenter;

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
        if (mPresenter != null) {
            mPresenter.detachView();
        }
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
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    /**
     * 初始化事件、数据
     */
    protected abstract void initEventAndData();
}

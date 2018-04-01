package com.liuleshuai.mvpdagger.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.liuleshuai.mvpdagger.di.component.ActivityComponent;
import com.liuleshuai.mvpdagger.di.component.DaggerActivityComponent;
import com.liuleshuai.mvpdagger.di.module.ActivityModule;
import com.liuleshuai.mvpdagger.tools.ActivityManager;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * @author liukuo
 */

public abstract class BaseActivity<T extends BasePresenter> extends SupportActivity implements BaseView {
    @Inject
    protected T mPresenter;
    private Unbinder unBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unBinder = ButterKnife.bind(this);
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
        unBinder.unbind();
    }

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();


    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder().
                appComponent(BaseApplication.getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    /**
     * 布局资源初始化
     */
    protected void onViewCreated() {
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    /**
     * 初始化事件、数据
     */
    protected abstract void initEventAndData();

    /**
     * 注入当前Activity所需的依赖
     */
    protected abstract void initInject();
}

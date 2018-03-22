package com.example.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.common.tools.ActivityManager;
import com.example.common.tools.ClassUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by LiuKuo at 2018/3/21
 */

public abstract class BaseActivity<T extends BasePresenter> extends SupportActivity implements BaseView {
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


    /**
     * 布局资源初始化
     */
    protected void onViewCreated() {
        inject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    /**
     * 初始化事件、数据
     */
    protected abstract void initEventAndData();

    /**
     * 调用映射代码（此处无法使用Dagger，因为不在一个包下）
     */
    protected void inject() {
        mPresenter = ClassUtil.getT(this, 0);
    }
}

package com.example.common.dagger.component;

import com.example.common.base.BaseActivity;
import com.example.common.base.BasePresenter;

import dagger.Component;

/**
 *
 * @author 67017
 * @date 2018/3/21
 */
@Component(modules = BasePresenter.class)
public interface ActivityComponent {
    void inject(BaseActivity baseActivity);
}

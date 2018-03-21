package com.example.common.base;

import javax.inject.Inject;

/**
 * Created by LiuKuo at 2018/3/21
 */

public class BasePresenter<T extends BaseView> {
    private T mView;

    @Inject
    public BasePresenter() {
    }

    public void attachView(T view) {
        this.mView = view;
    }

    public void detachView() {
        this.mView = null;
    }
}

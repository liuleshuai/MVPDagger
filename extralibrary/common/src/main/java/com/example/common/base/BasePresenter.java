package com.example.common.base;

/**
 * @author liukuo
 */

public class BasePresenter<T extends BaseView> {
    protected T mView;

    public BasePresenter() {
    }

    public void attachView(T view) {
        this.mView = view;
    }

    public void detachView() {
        this.mView = null;
    }
}

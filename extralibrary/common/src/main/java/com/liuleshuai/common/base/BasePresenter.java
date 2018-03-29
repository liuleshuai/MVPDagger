package com.liuleshuai.common.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author liukuo
 */

public class BasePresenter<T extends BaseView> {
    protected T mView;
    private CompositeDisposable compositeDisposable;

    /**
     * 添加事件管理
     * 用于管理事件的生命周期
     *
     * @param disposable 事件
     */
    protected void addDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    public void attachView(T view) {
        this.mView = view;
    }

    public void detachView() {
        this.mView = null;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }
}

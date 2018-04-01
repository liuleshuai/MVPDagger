package com.liuleshuai.mvpdagger.presenter;

import com.alibaba.android.arouter.launcher.ARouter;
import com.liuleshuai.mvpdagger.app.DataManager;
import com.liuleshuai.mvpdagger.model.SplashContract;
import com.liuleshuai.mvpdagger.ui.base.BasePresenter;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * Created by LiuKuo at 2018/3/22
 *
 * @author liukuo
 */

public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {
    private DataManager dataManager;

    @Inject
    public SplashPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void jump() {
        addDisposable(Observable.just(0).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        ARouter.getInstance().build("/activity/main").navigation();
                    }
                })
        );
    }

    @Override
    public void jumpDelay() {
        addDisposable(Observable.timer(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        ARouter.getInstance().build("/activity/main").navigation();
                    }
                })
        );
    }
}

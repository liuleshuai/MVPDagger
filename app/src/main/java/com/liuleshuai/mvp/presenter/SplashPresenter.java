package com.liuleshuai.mvp.presenter;

import com.liuleshuai.common.base.BasePresenter;
import com.liuleshuai.mvp.model.SplashContract;

/**
 * Created by LiuKuo at 2018/3/22
 *
 * @author liukuo
 */

public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter{
    public SplashPresenter() {
    }

    @Override
    public void changeColor() {
        mView.setColor();
    }
}

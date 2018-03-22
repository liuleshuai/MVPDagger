package com.example.liukuo.mvpdagger.presenter;

import com.example.common.base.BasePresenter;
import com.example.liukuo.mvpdagger.model.MainContract;

/**
 * Created by LiuKuo at 2018/3/22
 *
 * @author liukuo
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter{
    public MainPresenter() {
    }

    @Override
    public void changeColor() {
        mView.setColor();
    }
}

package com.liuleshuai.mvpdagger.presenter;

import com.liuleshuai.mvpdagger.app.DataManager;
import com.liuleshuai.mvpdagger.model.MainContract;
import com.liuleshuai.mvpdagger.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by LiuKuo at 2018/3/22
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private DataManager mDataManager;

    @Inject
    MainPresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }
}

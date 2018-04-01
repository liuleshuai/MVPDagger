package com.liuleshuai.mvpdagger.presenter;

import com.liuleshuai.mvpdagger.app.DataManager;
import com.liuleshuai.mvpdagger.model.WeChatContract;
import com.liuleshuai.mvpdagger.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by LiuKuo at 2018/3/22
 */

public class WeChatPresenter extends BasePresenter<WeChatContract.View> implements WeChatContract.Presenter {
    private DataManager mDataManager;

    @Inject
    public WeChatPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }
}

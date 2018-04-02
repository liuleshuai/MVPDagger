package com.liuleshuai.mvpdagger.presenter;

import com.alibaba.fastjson.JSON;
import com.liuleshuai.mvpdagger.app.DataManager;
import com.liuleshuai.mvpdagger.bean.MovieEntity;
import com.liuleshuai.mvpdagger.bean.UsefulSitesResponse;
import com.liuleshuai.mvpdagger.model.SearchDialogContract;
import com.liuleshuai.mvpdagger.tools.RxUtil;
import com.liuleshuai.mvpdagger.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by LiuKuo at 2018/3/23
 */

public class SearchDialogPresenter extends BasePresenter<SearchDialogContract.View> implements SearchDialogContract.Presenter {
    private DataManager mDataManager;

    @Inject
    public SearchDialogPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getMovieData(int start, int count) {
        addDisposable(mDataManager.getMovieTop(start, count)
                .compose(RxUtil.<MovieEntity>toMain())
                .subscribe(new Consumer<MovieEntity>() {
                    @Override
                    public void accept(MovieEntity movieEntity) throws Exception {
                        mView.showMovieData(JSON.toJSONString(movieEntity));
                    }
                })
        );
    }

    @Override
    public void getUsefulSites() {
        addDisposable(mDataManager.getUsefulSites()
                .compose(RxUtil.<UsefulSitesResponse>toMain())
                .subscribe(new Consumer<UsefulSitesResponse>() {
                    @Override
                    public void accept(UsefulSitesResponse usefulSitesResponse) throws Exception {
                        mView.showUsefulSites(JSON.toJSONString(usefulSitesResponse));
                    }
                })
        );
    }
}

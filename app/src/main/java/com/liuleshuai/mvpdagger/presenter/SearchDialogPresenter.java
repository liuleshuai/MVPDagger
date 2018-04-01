package com.liuleshuai.mvpdagger.presenter;

import com.alibaba.fastjson.JSON;
import com.liuleshuai.mvpdagger.app.Constants;
import com.liuleshuai.mvpdagger.app.DataManager;
import com.liuleshuai.mvpdagger.bean.MovieEntity;
import com.liuleshuai.mvpdagger.http.MovieLoader;
import com.liuleshuai.mvpdagger.model.SearchDialogContract;
import com.liuleshuai.mvpdagger.ui.base.BasePresenter;

import java.util.List;

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
    public void getMovieData() {
        MovieLoader.builder(Constants.MOVIE_URL).getMovie(0, 10)
                .subscribe(new Consumer<List<MovieEntity.SubjectsBean>>() {
                    @Override
                    public void accept(List<MovieEntity.SubjectsBean> subjectsBeen) throws Exception {
                        mView.showMovieData(JSON.toJSONString(subjectsBeen));
                    }
                });
    }
}

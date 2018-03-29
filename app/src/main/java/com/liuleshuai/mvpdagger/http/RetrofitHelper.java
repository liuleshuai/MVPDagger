package com.liuleshuai.mvpdagger.http;

import com.liuleshuai.mvpdagger.bean.MovieEntity;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by LiuKuo at 2018/3/29
 */

public class RetrofitHelper implements HttpHelper {
    private HttpApis httpApis;

    @Inject
    public RetrofitHelper(HttpApis httpApis) {
        this.httpApis = httpApis;
    }

    @Override
    public Flowable<MovieEntity> getMovieTop(int start, int count) {
        return httpApis.getMovieTop(start, count);
    }
}

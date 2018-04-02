package com.liuleshuai.mvpdagger.http;

import com.liuleshuai.mvpdagger.bean.MovieEntity;
import com.liuleshuai.mvpdagger.bean.UsefulSitesResponse;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Flowable;

/**
 * Created by LiuKuo at 2018/3/29
 */

public class RetrofitHelper implements HttpHelper {
    private HttpApis httpApis;

    @Inject
    public RetrofitHelper(@Named("WanAndroid") HttpApis httpApis) {
        this.httpApis = httpApis;
    }

    @Override
    public Flowable<MovieEntity> getMovieTop(int start, int count) {
        return httpApis.getMovieTop(start, count);
    }

    @Override
    public Flowable<UsefulSitesResponse> getUsefulSites() {
        return httpApis.getUsefulSites();
    }
}

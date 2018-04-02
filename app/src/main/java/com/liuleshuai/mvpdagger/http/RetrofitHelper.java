package com.liuleshuai.mvpdagger.http;

import com.liuleshuai.mvpdagger.bean.MovieEntity;
import com.liuleshuai.mvpdagger.bean.UsefulSitesResponse;
import com.liuleshuai.mvpdagger.http.apis.DouBanApis;
import com.liuleshuai.mvpdagger.http.apis.WanAndroidApis;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * 注：添加网站api时修改构造函数
 * <p>
 * Created by LiuKuo at 2018/3/29
 */

public class RetrofitHelper implements HttpHelper {

    private DouBanApis douBanApis;
    private WanAndroidApis wanAndroidApis;

    @Inject
    public RetrofitHelper(DouBanApis douBanApis, WanAndroidApis wanAndroidApis) {
        this.douBanApis = douBanApis;
        this.wanAndroidApis = wanAndroidApis;
    }

    @Override
    public Flowable<MovieEntity> getMovieTop(int start, int count) {
        return douBanApis.getMovieTop(start, count);
    }

    @Override
    public Flowable<UsefulSitesResponse> getUsefulSites() {
        return wanAndroidApis.getUsefulSites();
    }
}

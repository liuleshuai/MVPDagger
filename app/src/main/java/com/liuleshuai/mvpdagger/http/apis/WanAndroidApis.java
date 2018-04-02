package com.liuleshuai.mvpdagger.http.apis;

import com.liuleshuai.mvpdagger.bean.UsefulSitesResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by LiuKuo at 2018/4/2
 */

public interface WanAndroidApis {
    /**
     * 常用网站
     * http://www.wanandroid.com/friend/json
     *
     * @return Observable<UsefulSitesResponse>
     */
    @GET("friend/json")
    Flowable<UsefulSitesResponse> getUsefulSites();
}

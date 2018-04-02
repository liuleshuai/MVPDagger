package com.liuleshuai.mvpdagger.http;

import com.liuleshuai.mvpdagger.bean.MovieEntity;
import com.liuleshuai.mvpdagger.bean.UsefulSitesResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by LiuKuo at 2018/3/29
 */

public interface HttpApis {

    @GET("top250")
    Flowable<MovieEntity> getMovieTop(@Query("start") int start, @Query("count") int count);

    /**
     * 常用网站
     * http://www.wanandroid.com/friend/json
     *
     * @return Observable<UsefulSitesResponse>
     */
    @GET("friend/json")
    Flowable<UsefulSitesResponse> getUsefulSites();
}

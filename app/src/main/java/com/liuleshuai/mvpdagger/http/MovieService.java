package com.liuleshuai.mvpdagger.http;

import com.liuleshuai.mvpdagger.bean.MovieEntity;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by LiuKuo at 2018/3/26
 */

public interface MovieService {
    @GET("top250")
    Flowable<MovieEntity> getMovieTop(@Query("start") int start, @Query("count") int count);
}

package com.liuleshuai.mvpdagger.http;

import com.liuleshuai.mvpdagger.bean.MovieEntity;

import io.reactivex.Flowable;

/**
 * Created by LiuKuo at 2018/3/29
 */

public interface HttpHelper {
    
    Flowable<MovieEntity> getMovieTop(int start, int count);
}

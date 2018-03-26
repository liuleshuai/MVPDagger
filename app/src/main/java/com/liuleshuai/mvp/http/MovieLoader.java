package com.liuleshuai.mvp.http;

import android.support.annotation.NonNull;

import com.liuleshuai.common.http.RetrofitManager;
import com.liuleshuai.mvp.bean.MovieEntity;

import org.reactivestreams.Publisher;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by LiuKuo at 2018/3/26
 */

public class MovieLoader {
    private MovieService retrofitService;

    public MovieLoader(String baseUrl) {
        retrofitService = RetrofitManager.getInstance(baseUrl).creat(MovieService.class);
    }

    public static MovieLoader builder(@NonNull String baseUrl) {
        return Loader.getInstance(baseUrl);
    }

    private static class Loader {
        private static MovieLoader instance;

        private static MovieLoader getInstance(String baseUrl) {
            if (instance == null) {
                instance = new MovieLoader(baseUrl);
            }
            return instance;
        }
    }

    public Flowable<List<MovieEntity.SubjectsBean>> getMovie(int start, int count) {
        return retrofitService.getMovieTop(start, count)
                .map(new Function<MovieEntity, List<MovieEntity.SubjectsBean>>() {
                    @Override
                    public List<MovieEntity.SubjectsBean> apply(@NonNull MovieEntity movieEntity) throws Exception {
                        return movieEntity.getSubjects();
                    }
                }).compose(this.<List<MovieEntity.SubjectsBean>>toMain());
    }

    public <T> FlowableTransformer<T, T> toMain() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(@io.reactivex.annotations.NonNull Flowable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}

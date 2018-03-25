package com.liuleshuai.common.http;

import com.liuleshuai.common.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 67017 on 2018/3/25.
 */

public class RetrofitManager {
    private static final int DEFAULT_TIME_OUT = 5;
    private static final int DEFAULT_READ_TIME_OUT = 10;
    private static final int DEFAULT_WRITE_TIME_OUT = 10;
    private Retrofit retrofit;

    private RetrofitManager(String baseUrl) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_WRITE_TIME_OUT, TimeUnit.SECONDS);
        //添加拦截
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(new LoggingInterceptor());
        }

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(baseUrl)
                // 将Json结果并解析成DAO
                .addConverterFactory(GsonConverterFactory.create())
                // 添加RxJava2支持
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private static class SingletonHolder {
        private static RetrofitManager instance;

        public static RetrofitManager getInstance(String baseUrl) {
            if (instance == null) {
                return instance = new RetrofitManager(baseUrl);
            } else {
                return instance;
            }
        }
    }

    public static RetrofitManager getInstance(String baseUrl) {
        return SingletonHolder.getInstance(baseUrl);
    }

    /**
     * 获取对应的Service
     *
     * @param service Service 的 class
     * @param <T>
     * @return
     */
    public <T> T creat(Class<T> service) {
        return retrofit.create(service);
    }
}


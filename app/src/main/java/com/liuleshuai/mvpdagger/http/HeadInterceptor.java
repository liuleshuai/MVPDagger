package com.liuleshuai.mvpdagger.http;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by LiuKuo at 2018/1/25
 */

public class HeadInterceptor implements Interceptor {
    private Map<String, String> params = new HashMap<>();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();
        //新的请求
        Request.Builder requestBuilder = oldRequest.newBuilder();
        requestBuilder.method(oldRequest.method(), oldRequest.body());
        //添加公共参数,添加到header中
        if (params.size() > 0) {
            for (Map.Entry<String, String> temp : params.entrySet()) {
                requestBuilder.addHeader(temp.getKey(), temp.getValue());
            }
        }
        Request newRequest = requestBuilder.build();
        return chain.proceed(newRequest);
    }

    public static class Builder {
        HeadInterceptor headInterceptor;

        Builder() {
            headInterceptor = new HeadInterceptor();
        }

        public Builder addHeaderParams(String key, String value) {
            headInterceptor.params.put(key, value);
            return this;
        }

        public Builder addHeaderParams(String key, int value) {
            return addHeaderParams(key, String.valueOf(value));
        }

        public Builder addHeaderParams(String key, float value) {
            return addHeaderParams(key, String.valueOf(value));
        }

        public Builder addHeaderParams(String key, long value) {
            return addHeaderParams(key, String.valueOf(value));
        }

        public Builder addHeaderParams(String key, double value) {
            return addHeaderParams(key, String.valueOf(value));
        }

        public HeadInterceptor build() {
            return headInterceptor;
        }
    }


}

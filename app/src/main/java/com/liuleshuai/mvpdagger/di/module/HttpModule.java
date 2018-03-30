package com.liuleshuai.mvpdagger.di.module;

import com.liuleshuai.mvpdagger.BuildConfig;
import com.liuleshuai.mvpdagger.app.Constants;
import com.liuleshuai.mvpdagger.app.MyApplication;
import com.liuleshuai.mvpdagger.di.qualifier.CustomeNameUrl;
import com.liuleshuai.mvpdagger.http.HttpApis;
import com.liuleshuai.mvpdagger.http.cookies.CookiesManager;
import com.liuleshuai.mvpdagger.tools.NetWorkUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LiuKuo at 2018/3/29
 */
@Module
public class HttpModule {
    @Singleton
    @Provides
    HttpApis provideHttpApis(@CustomeNameUrl Retrofit retrofit) {
        return retrofit.create(HttpApis.class);
    }

    @Singleton
    @CustomeNameUrl
    @Provides
    Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, Constants.MOVIE_URL);
    }

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    /**
     * 如果服务器不支持缓存就可能没有指定这个头部，这种情况下我们就需要使用Interceptor来重写Respose的头部信息
     *
     * @param builder
     * @return
     */
    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(final OkHttpClient.Builder builder) {
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }
        File cacheFile = new File(Constants.PATH_CACHE);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50); // 50M
        //拦截器中设置缓存
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (NetWorkUtils.isNetConnected(MyApplication.getAppContext())) {
                    request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
                }
                Response response = chain.proceed(request);
              /*  maxAge:没有超出maxAge,不管怎么样都是返回缓存数据，超过了maxAge,发起新的请求获取数据更新，请求失败返回缓存数据。
                maxStale:没有超过maxStale，不管怎么样都返回缓存数据，超过了maxStale,发起请求获取更新数据，请求失败返回失败*/
                if (NetWorkUtils.isNetConnected(MyApplication.getAppContext())) {
                    int maxAge = 0;
                   /* 有网络时，请求成功时就会缓存数据，设置缓存超时时间为0；
                      设置缓存时间是为了区别再次请求时，是重新获取数据，还是返回缓存数据。*/
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();
                } else {
                    /* 无网络时，设置超时为4周
                       所以说，四周内会返回缓存数据（如果有的话），四周后重新获取数据。*/
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };
        builder.addInterceptor(cacheInterceptor);
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.cache(cache);

        builder.connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(Constants.READ_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(Constants.WRITE_TIMEOUT, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        //cookie认证
        builder.cookieJar(new CookiesManager());
        return builder.build();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}

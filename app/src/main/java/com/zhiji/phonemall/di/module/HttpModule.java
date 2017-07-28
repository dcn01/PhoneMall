package com.zhiji.phonemall.di.module;

import com.zhiji.phonemall.http.api.ApiService;
import com.zhiji.phonemall.http.interceptor.LoggingInterceptor;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/27
 *     desc   :
 * </pre>
 */
@Module
public class HttpModule {

  @Singleton
  @Provides
  Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient okHttpClient) {
    return createRetrofit(builder, okHttpClient, ApiService.BASE_URL);
  }

  @Singleton
  @Provides
  Retrofit.Builder provideRetrofitBuilder() {
    return new Retrofit.Builder();
  }

  @Singleton
  @Provides
  OkHttpClient.Builder provideOkHttpClientBuilder() {
    return new OkHttpClient.Builder();
  }

  @Singleton
  @Provides
  OkHttpClient provideOkHttpClinet(OkHttpClient.Builder builder) {
    builder.addInterceptor(new LoggingInterceptor());//添加日志拦截器，拦截request和response信息
    builder.connectTimeout(10, TimeUnit.SECONDS);
    builder.readTimeout(20, TimeUnit.SECONDS);
    builder.writeTimeout(20, TimeUnit.SECONDS);
    builder.retryOnConnectionFailure(true);
    return builder.build();
  }

  @Singleton
  @Provides
  ApiService provideApiService(Retrofit retrofit) {
    return retrofit.create(ApiService.class);
  }


  /**
   * 创建Retrofit
   */
  private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient okHttpClient,
      String baseUrl) {
    return builder.baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }
}

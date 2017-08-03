package com.zhiji.phonemall.http.interceptor;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/31
 *     desc   : OkHttp缓存拦截器
 * </pre>
 */
public class CacheInterceptor implements Interceptor {

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    Response response = chain.proceed(request);
    //缓存60s
    int maxAge = 60;
    return response.newBuilder()
        .removeHeader("Cache-Control")
        .removeHeader("Pragma")
        .header("Cache-Control", "public,max-age=" + maxAge)
        .build();
  }
}

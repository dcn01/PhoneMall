package com.zhiji.phonemall.http.interceptor;

import com.zhiji.phonemall.utils.LogUtil;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/28
 *     desc   :日志拦截器
 * </pre>
 */
public class LoggingInterceptor implements Interceptor {

  @Override
  public Response intercept(Interceptor.Chain chain) throws IOException {
    Request request = chain.request();
    long t1 = System.nanoTime();
    LogUtil.i("OkHttp", String.format("Sending request %s on %s%n%s", request.url(), chain.connection(),
            request.headers()));
    Response response = chain.proceed(request);
    long t2 = System.nanoTime();
    LogUtil.i("OkHttp", String.format("Received response for %s in %.1fms%n%s", response.request().url(),
            (t2 - t1) / 1e6d, response.headers()));
    return response;
  }
}

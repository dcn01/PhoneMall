package com.zhiji.phonemall.http.interceptor;

import com.zhiji.phonemall.app.App;
import com.zhiji.phonemall.utils.NetUtil;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/31
 *     desc   :
 * </pre>
 */
public class NetCacheInterceptor implements Interceptor {

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    if (!NetUtil.isNetworkAvailable(App.mInstance)) {
      request = new Request.Builder()
          .cacheControl(CacheControl.FORCE_CACHE)
          .build();
    }
    if (NetUtil.isNetworkAvailable(App.mInstance)) {
      return new Response.Builder()
          .removeHeader("Pragma")
          .header("Cache-Control", "public,max-age=" + 0)
          .build();
    } else {
      //设置无网络的缓存时间
      int maxAge = 4 * 24 * 60 * 60;
      return new Response.Builder()
          .removeHeader("Pragma")
          .header("Cache-Control", "public,only-if-cached,max-stale=" + maxAge)
          .build();
    }
  }
}

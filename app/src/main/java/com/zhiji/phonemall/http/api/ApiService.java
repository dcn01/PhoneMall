package com.zhiji.phonemall.http.api;

import com.zhiji.phonemall.data.network.model.LoginResponse;
import com.zhiji.phonemall.data.network.model.TestResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/27
 *     desc   :
 * </pre>
 */
public interface ApiService {

  String BASE_URL = "http://gank.io/api/data/";

  @GET
  Observable<LoginResponse> login();

  @GET("福利/{count}/{page}")
  Observable<TestResponse> requestSplashData(@Path("count") int count, @Path("page") int page);
}

package com.zhiji.phonemall.data.network;

import com.zhiji.phonemall.data.network.model.LoginRequest;
import com.zhiji.phonemall.data.network.model.LoginResponse;
import com.zhiji.phonemall.data.network.model.TestResponse;
import com.zhiji.phonemall.http.api.ApiService;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/28
 *     desc   :
 * </pre>
 */
@Singleton
public class AppApiHelper implements ApiHelper {

  private final ApiService mApiService;

  @Inject
  public AppApiHelper(ApiService apiService) {
    mApiService = apiService;
  }

  @Override
  public Observable<LoginResponse> login(LoginRequest loginRequest) {
    return mApiService.login();
  }

  @Override
  public Observable<TestResponse> requestSplashData() {
    return mApiService.requestSplashData(3, 1);
  }
}

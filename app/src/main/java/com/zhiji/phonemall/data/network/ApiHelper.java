package com.zhiji.phonemall.data.network;

import com.zhiji.phonemall.data.network.model.LoginRequest;
import com.zhiji.phonemall.data.network.model.LoginResponse;
import com.zhiji.phonemall.data.network.model.TestResponse;
import io.reactivex.Observable;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/28
 *     desc   : 网络操作接口
 * </pre>
 */
public interface ApiHelper {

  Observable<LoginResponse> login(LoginRequest loginRequest);
  Observable<TestResponse> requestSplashData();
}

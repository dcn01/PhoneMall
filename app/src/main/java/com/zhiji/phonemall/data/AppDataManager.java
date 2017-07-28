package com.zhiji.phonemall.data;

import com.zhiji.phonemall.data.db.DbHelper;
import com.zhiji.phonemall.data.db.model.User;
import com.zhiji.phonemall.data.network.ApiHelper;
import com.zhiji.phonemall.data.network.model.LoginRequest;
import com.zhiji.phonemall.data.network.model.LoginResponse;
import com.zhiji.phonemall.data.network.model.TestResponse;
import com.zhiji.phonemall.data.prefs.PreferencesHelper;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/28
 *     desc   : App中数据管理
 * </pre>
 */
@Singleton
public class AppDataManager implements DataManager {

  private final DbHelper mDbHelper;
  private final ApiHelper mApiHelper;
  private final PreferencesHelper mPreferencesHelper;

  @Inject
  public AppDataManager( DbHelper dbHelper, ApiHelper apiHelper,
      PreferencesHelper preferencesHelper) {
    this.mDbHelper = dbHelper;
    this.mApiHelper = apiHelper;
    this.mPreferencesHelper = preferencesHelper;
  }

  @Override
  public void setAccessToken(String accessToken) {
    mPreferencesHelper.setAccessToken(accessToken);
  }

  @Override
  public String getAccessToken() {
    return mPreferencesHelper.getAccessToken();
  }

  @Override
  public Observable<Long> insertUser(User user) {
    return mDbHelper.insertUser(user);
  }

  @Override
  public Observable<LoginResponse> login(LoginRequest loginRequest) {
    return mApiHelper.login(loginRequest);
  }

  @Override
  public Observable<TestResponse> requestSplashData() {
    return mApiHelper.requestSplashData();
  }
}

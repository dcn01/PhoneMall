package com.zhiji.phonemall.data.prefs;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/28
 *     desc   : SharedPreferences操作接口
 * </pre>
 */
public interface PreferencesHelper {

  void setAccessToken(String accessToken);

  String getAccessToken();

}

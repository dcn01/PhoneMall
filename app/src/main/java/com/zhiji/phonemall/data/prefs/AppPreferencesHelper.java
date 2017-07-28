package com.zhiji.phonemall.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import com.zhiji.phonemall.di.qualifier.ApplicationContext;
import com.zhiji.phonemall.di.qualifier.PreferencesInfo;
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
public class AppPreferencesHelper implements PreferencesHelper {

  private final SharedPreferences mPrefs;
  private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";

  @Inject
  public AppPreferencesHelper(@ApplicationContext Context context, @PreferencesInfo String name) {
    mPrefs = context.getSharedPreferences(name, Context.MODE_PRIVATE);
  }

  @Override
  public void setAccessToken(String accessToken) {
    mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply();
  }

  @Override
  public String getAccessToken() {
    return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null);
  }
}

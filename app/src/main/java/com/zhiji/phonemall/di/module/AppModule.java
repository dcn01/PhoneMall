package com.zhiji.phonemall.di.module;

import android.app.Application;
import android.content.Context;
import com.zhiji.phonemall.data.AppDataManager;
import com.zhiji.phonemall.data.DataManager;
import com.zhiji.phonemall.data.db.AppDbHelper;
import com.zhiji.phonemall.data.db.DbHelper;
import com.zhiji.phonemall.data.network.ApiHelper;
import com.zhiji.phonemall.data.network.AppApiHelper;
import com.zhiji.phonemall.data.prefs.AppPreferencesHelper;
import com.zhiji.phonemall.data.prefs.PreferencesHelper;
import com.zhiji.phonemall.di.qualifier.ApplicationContext;
import com.zhiji.phonemall.di.qualifier.DatabaseInfo;
import com.zhiji.phonemall.di.qualifier.PreferencesInfo;
import com.zhiji.phonemall.utils.AppConstants;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/27
 *     desc   :
 * </pre>
 */
@Module
public class AppModule {

  private final Application mApplication;

  public AppModule(Application application) {
    this.mApplication = application;
  }

  @ApplicationContext
  @Provides
  Context provideContext() {
    return mApplication.getApplicationContext();
  }

  @Provides
  Application provideApplication() {
    return mApplication;
  }

  @Provides
  @Singleton
  DataManager provideDataManager(AppDataManager appDataManager) {
    return appDataManager;
  }

  @Provides
  @Singleton
  DbHelper provideDbHelper(AppDbHelper appDbHelper) {
    return appDbHelper;
  }

  @Provides
  @DatabaseInfo
  String provideDatabaseName() {
    return AppConstants.DB_NAME;
  }

  @Provides
  @Singleton
  ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
    return appApiHelper;
  }

  @Provides
  @Singleton
  PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
    return appPreferencesHelper;
  }

  @Provides
  @PreferencesInfo
  String providePreferencesName() {
    return AppConstants.PREF_NAME;
  }
}

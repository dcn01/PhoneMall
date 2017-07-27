package com.zhiji.phonemall.di.module;

import android.content.Context;
import com.zhiji.phonemall.app.MyApp;
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

  private final MyApp mApp;

  public AppModule(MyApp mApp) {
    this.mApp = mApp;
  }

  @Singleton
  @Provides
  Context provideApplicationContext() {
    return mApp.getApplicationContext();
  }

  @Singleton
  @Provides
  MyApp provideApplication() {
    return mApp;
  }
}

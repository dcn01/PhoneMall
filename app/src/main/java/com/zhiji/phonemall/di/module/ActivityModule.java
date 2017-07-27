package com.zhiji.phonemall.di.module;

import android.app.Activity;
import com.zhiji.phonemall.di.scope.ActivityScope;
import com.zhiji.phonemall.ui.main.MainModel;
import com.zhiji.phonemall.ui.main.MainPresenter;
import com.zhiji.phonemall.ui.splash.SplashModel;
import com.zhiji.phonemall.ui.splash.SplashPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/26
 *     desc   :
 * </pre>
 */
@Module
public class ActivityModule {

  private Activity mActivity;

  public ActivityModule(Activity mActivity) {
    this.mActivity = mActivity;
  }

  @Provides
  @ActivityScope
  Activity provideActivity() {
    return mActivity;
  }
}

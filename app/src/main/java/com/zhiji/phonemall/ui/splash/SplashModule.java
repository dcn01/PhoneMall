package com.zhiji.phonemall.ui.splash;

import com.zhiji.phonemall.ui.splash.SplashContract.IView;
import dagger.Module;
import dagger.Provides;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/27
 *     desc   : 利用Dagger2提供Model和View
 * </pre>
 */
@Module
public class SplashModule {

  private final SplashContract.IView mView;

  public SplashModule(IView view) {
    mView = view;
  }

  @Provides
  SplashContract.IView provideIView() {
    return mView;
  }

  @Provides
  SplashModel provideSplashModel() {
    return new SplashModel();
  }

}

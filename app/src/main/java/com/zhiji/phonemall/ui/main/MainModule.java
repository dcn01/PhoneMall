package com.zhiji.phonemall.ui.main;

import com.zhiji.phonemall.ui.main.MainContract.IView;
import dagger.Module;
import dagger.Provides;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/27
 *     desc   :
 * </pre>
 */
@Module
public class MainModule {

  private final MainContract.IView mView;

  public MainModule(IView view) {
    mView = view;
  }

  @Provides
  MainContract.IView provideIView() {
    return mView;
  }
}

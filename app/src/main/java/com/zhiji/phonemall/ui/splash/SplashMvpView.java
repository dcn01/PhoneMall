package com.zhiji.phonemall.ui.splash;

import com.zhiji.phonemall.base.MvpView;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/28
 *     desc   :
 * </pre>
 */
public interface SplashMvpView extends MvpView {

  void openLoginActivity();

  void openMainActivity();
  void showTime(String time);
}

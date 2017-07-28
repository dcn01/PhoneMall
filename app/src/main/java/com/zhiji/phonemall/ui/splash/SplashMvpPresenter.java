package com.zhiji.phonemall.ui.splash;

import com.zhiji.phonemall.base.MvpPresenter;
import com.zhiji.phonemall.base.MvpView;
import com.zhiji.phonemall.di.scope.PerActivity;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/28
 *     desc   :
 * </pre>
 */
@PerActivity
public interface SplashMvpPresenter<V extends MvpView> extends MvpPresenter<V> {
  void requestSplashData();
}

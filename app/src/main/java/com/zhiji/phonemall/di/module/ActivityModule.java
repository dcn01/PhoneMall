package com.zhiji.phonemall.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.zhiji.phonemall.di.qualifier.ActivityContext;
import com.zhiji.phonemall.di.scope.PerActivity;
import com.zhiji.phonemall.ui.main.MainMvpPresenter;
import com.zhiji.phonemall.ui.main.MainMvpView;
import com.zhiji.phonemall.ui.main.MainPresenter;
import com.zhiji.phonemall.ui.splash.SplashMvpPresenter;
import com.zhiji.phonemall.ui.splash.SplashMvpView;
import com.zhiji.phonemall.ui.splash.SplashPresenter;
import com.zhiji.phonemall.utils.rx.AppSchedulerProvider;
import com.zhiji.phonemall.utils.rx.SchedulerProvider;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/26
 *     desc   :
 * </pre>
 */
@Module
public class ActivityModule {

  private final AppCompatActivity mActivity;

  public ActivityModule(AppCompatActivity activity) {
    this.mActivity = activity;
  }

  @Provides
  @ActivityContext
  Context provideContext() {
    return mActivity;
  }

  @Provides
  AppCompatActivity provideActivity() {
    return mActivity;
  }

  @Provides
  CompositeDisposable provideCompositeDisposable() {
    return new CompositeDisposable();
  }
  @Provides
  SchedulerProvider provideSchedulerProvider() {
    return new AppSchedulerProvider();
  }

  @Provides
  @PerActivity
  SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
      SplashPresenter<SplashMvpView> presenter) {
    return presenter;
  }

  @Provides
  @PerActivity
  MainMvpPresenter<MainMvpView> provideMainPresenter(
      MainPresenter<MainMvpView> presenter) {
    return presenter;
  }


}

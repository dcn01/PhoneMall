package com.zhiji.phonemall.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.zhiji.phonemall.di.qualifier.ActivityContext;
import com.zhiji.phonemall.di.scope.PerActivity;
import com.zhiji.phonemall.ui.cart.CartMvpPresenter;
import com.zhiji.phonemall.ui.cart.CartMvpView;
import com.zhiji.phonemall.ui.cart.CartPresenter;
import com.zhiji.phonemall.ui.category.CategoryMvpPresenter;
import com.zhiji.phonemall.ui.category.CategoryMvpView;
import com.zhiji.phonemall.ui.category.CategoryPresenter;
import com.zhiji.phonemall.ui.home.HomeMvpPresenter;
import com.zhiji.phonemall.ui.home.HomeMvpView;
import com.zhiji.phonemall.ui.home.HomePresenter;
import com.zhiji.phonemall.ui.mine.MineMvpPresenter;
import com.zhiji.phonemall.ui.mine.MineMvpView;
import com.zhiji.phonemall.ui.mine.MinePresenter;
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
  HomeMvpPresenter<HomeMvpView> provideHomePresenter(HomePresenter<HomeMvpView> presenter) {
    return presenter;
  }
  @Provides
  CategoryMvpPresenter<CategoryMvpView> provideCategoryPresenter(CategoryPresenter<CategoryMvpView> presenter) {
    return presenter;
  }
  @Provides
  CartMvpPresenter<CartMvpView> provideCartPresenter(CartPresenter<CartMvpView> presenter) {
    return presenter;
  }
  @Provides
  MineMvpPresenter<MineMvpView> provideMinePresenter(MinePresenter<MineMvpView> presenter) {
    return presenter;
  }



}

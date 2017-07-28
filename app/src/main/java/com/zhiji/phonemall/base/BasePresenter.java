package com.zhiji.phonemall.base;

import com.zhiji.phonemall.data.DataManager;
import com.zhiji.phonemall.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/28
 *     desc   :
 * </pre>
 */
public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

  private final DataManager mDataManager;
  private final CompositeDisposable mCompositeDisposable;
  private final SchedulerProvider mSchedulerProvider;
  private V mMvpView;

  @Inject
  public BasePresenter(DataManager dataManager, CompositeDisposable compositeDisposable,
      SchedulerProvider schedulerProvider) {
    this.mDataManager = dataManager;
    this.mCompositeDisposable = compositeDisposable;
    this.mSchedulerProvider = schedulerProvider;
  }

  @Override
  public void attachView(V view) {
    this.mMvpView = view;

  }

  /**
   * com.squareup.retrofit2:adapter-rxjava2:2.3.0中，调用dispose()方法后，Retrofit的网络请求也会取消，如下
   *
   * @Override public void dispose() { call.cancel(); } 具体查看源码可知
   */
  @Override
  public void detachView() {
    this.mMvpView = null;
    mCompositeDisposable.dispose();
  }

  public DataManager getDataManager() {
    return mDataManager;
  }

  public CompositeDisposable getCompositeDisposable() {
    return mCompositeDisposable;
  }

  public SchedulerProvider getSchedulerProvider() {
    return mSchedulerProvider;
  }

  public V getMvpView() {
    return mMvpView;
  }
}

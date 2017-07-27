package com.zhiji.phonemall.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/27
 *     desc   :
 * </pre>
 */
public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

  protected T mView;
  /**
   * 进行订阅的保存，统一管理
   */
  protected CompositeDisposable mCompositeDisposable;

  /**
   * 解除所有的订阅
   */
  protected void unSubscribe() {
    if (mCompositeDisposable != null) {
      mCompositeDisposable.clear();
    }
  }

  /**
   * 增加一个订阅
   */
  protected void addSubscribe(Disposable subscription) {
    if (mCompositeDisposable == null) {
      mCompositeDisposable = new CompositeDisposable();
    }
    mCompositeDisposable.add(subscription);
  }

  @Override
  public void attachView(T view) {
    this.mView = view;
  }

  @Override
  public void detachView() {
    this.mView = null;
    unSubscribe();
  }
}

package com.zhiji.phonemall.base;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/26
 *     desc   :
 * </pre>
 */
public interface MvpPresenter<V extends MvpView> {

  void attachView(V view);

  void detachView();
}

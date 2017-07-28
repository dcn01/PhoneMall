package com.zhiji.phonemall.base;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/26
 *     desc   :
 * </pre>
 */
public interface MvpView {

  void showLoading();

  void hideLoading();

  void showMessage(String msg);
}

package com.zhiji.phonemall.ui.splash;

import com.zhiji.phonemall.base.BasePresenter;
import com.zhiji.phonemall.base.BaseView;
import com.zhiji.phonemall.base.RxPresenter;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/26
 *     desc   :
 * </pre>
 */
public class SplashContract {

  interface IPresenter extends BasePresenter<IView>{

  }

  interface IView extends BaseView {

    void setSplashData();
  }
}

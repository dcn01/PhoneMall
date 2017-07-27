package com.zhiji.phonemall.ui.main;

import com.zhiji.phonemall.base.BasePresenter;
import com.zhiji.phonemall.base.BaseView;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/26
 *     desc   :
 * </pre>
 */
public class MainContract {

  interface IPresenter extends BasePresenter<IView> {
    void getMainData();
  }

  interface IView extends BaseView {

  }

}

package com.zhiji.phonemall.ui.main;

import com.zhiji.phonemall.base.RxPresenter;
import com.zhiji.phonemall.ui.main.MainContract.IPresenter;
import com.zhiji.phonemall.ui.main.MainContract.IView;
import javax.inject.Inject;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/26
 *     desc   :
 * </pre>
 */
public class MainPresenter extends RxPresenter<IView> implements IPresenter {

  @Inject
  public MainPresenter(IView view) {
    attachView(view);
  }

  @Override
  public void getMainData() {
    mView.setMainData();
  }
}

package com.zhiji.phonemall.ui.main;

import com.zhiji.phonemall.ui.main.MainContract.IView;
import javax.inject.Inject;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/26
 *     desc   :
 * </pre>
 */
public class MainPresenter implements MainContract.IPresenter {

  private MainContract.IView mView;
  private MainModel mMainModel;
  @Inject
  public MainPresenter(IView view, MainModel mainModel) {
    this.mMainModel = mainModel;
    attachView(view);
  }

  @Override
  public void attachView(IView view) {
    this.mView = view;
  }

  @Override
  public void detachView() {
    mView = null;
  }

  @Override
  public void getMainData() {
    mView.showMessage(mMainModel.getMainData());

  }
}

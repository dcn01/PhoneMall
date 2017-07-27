package com.zhiji.phonemall.ui.splash;

import com.zhiji.phonemall.ui.splash.SplashContract.IPresenter;
import com.zhiji.phonemall.ui.splash.SplashContract.IView;
import com.zhiji.phonemall.utils.LogUtil;
import javax.inject.Inject;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/26
 *     desc   :
 * </pre>
 */
public class SplashPresenter implements IPresenter {

  private SplashModel mSplashModel;
  private IView mView;

  @Inject
  public SplashPresenter(IView mView, SplashModel splashModel) {
    LogUtil.d("TAG", mView.toString() + splashModel.toString());
    this.mSplashModel = splashModel;
    attachView(mView);
  }

  @Override
  public void attachView(IView view) {
    this.mView = view;
  }

  @Override
  public void detachView() {
    mView = null;
  }

  public void getData() {
    boolean isSuccess=mSplashModel.getData();
    if(isSuccess){
      mView.showMessage("请求成功");
    }
  }
}

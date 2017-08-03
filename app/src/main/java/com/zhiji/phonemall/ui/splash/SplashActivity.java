package com.zhiji.phonemall.ui.splash;

import com.zhiji.phonemall.R;
import com.zhiji.phonemall.app.App;
import com.zhiji.phonemall.base.BaseActivity;
import com.zhiji.phonemall.ui.main.MainActivity;
import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements SplashMvpView {

  @Inject
  SplashMvpPresenter<SplashMvpView> mPresenter;
  private static final String TAG = "SplashActivity";

  @Override
  protected int provideLayoutId() {
    return R.layout.activity_splash;
  }

  @Override
  protected void initView() {
    mPresenter.attachView(this);
    //do something...
    mPresenter.requestSplashData();
  }

  /**
   * 利用Dagger2注入Presenter
   */
  @Override
  protected void initInject() {
    getActivityComponent().inject(this);
  }

  @Override
  public void showLoading() {
    showProgressDialog();

  }

  @Override
  public void hideLoading() {
    hideProgressDialog();

  }

  @Override
  public void showMessage(String msg) {
    showShortToast(msg);
  }

  @Override
  public void openLoginActivity() {

  }

  @Override
  public void openMainActivity() {
    MainActivity.openActivity(this);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mPresenter.detachView();
  }
}

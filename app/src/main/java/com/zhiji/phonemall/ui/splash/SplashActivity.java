package com.zhiji.phonemall.ui.splash;

import com.zhiji.phonemall.R;
import com.zhiji.phonemall.base.BaseActivity;

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.IView {

  private static final String TAG = "SplashActivity";

  @Override
  protected int provideLayoutId() {
    return R.layout.activity_splash;
  }

  @Override
  protected void initView() {
    mPresenter.getData();
  }

  @Override
  protected void initInject() {
    DaggerSplashComponent.builder().splashModule(new SplashModule(this)).build().inject(this);
  }

  @Override
  public void showLoading() {

  }

  @Override
  public void hideLoading() {

  }

  @Override
  public void showMessage(String msg) {
    showShortToast(msg);
  }
}

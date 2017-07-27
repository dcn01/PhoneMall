package com.zhiji.phonemall.ui.splash;

import com.zhiji.phonemall.R;
import com.zhiji.phonemall.app.MyApp;
import com.zhiji.phonemall.base.BaseActivity;
import com.zhiji.phonemall.ui.main.MainActivity;

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.IView {

  private static final String TAG = "SplashActivity";

  @Override
  protected int provideLayoutId() {
    return R.layout.activity_splash;
  }

  @Override
  protected void initView() {
    mPresenter.getSplashData();
  }

  @Override
  protected void initInject() {
    DaggerSplashComponent.builder().appComponent(MyApp.getAppComponent())
        .splashModule(new SplashModule(this)).build().inject(this);
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
  public void setSplashData() {
    MainActivity.actionStart(this);
    finish();
  }
}

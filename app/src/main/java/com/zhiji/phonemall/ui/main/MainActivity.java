package com.zhiji.phonemall.ui.main;

import com.zhiji.phonemall.R;
import com.zhiji.phonemall.base.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.IView {

  @Override
  protected int provideLayoutId() {
    return R.layout.activity_main;
  }

  @Override
  protected void initView() {

  }

  @Override
  protected void initInject() {

  }

  @Override
  public void showLoading() {

  }

  @Override
  public void hideLoading() {

  }

  @Override
  public void showMessage(String msg) {

  }
}

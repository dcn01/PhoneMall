package com.zhiji.phonemall.ui.main;

import android.content.Context;
import android.content.Intent;
import com.zhiji.phonemall.R;
import com.zhiji.phonemall.app.MyApp;
import com.zhiji.phonemall.base.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.IView {

  @Override
  protected int provideLayoutId() {
    return R.layout.activity_main;
  }

  @Override
  protected void initView() {
    mPresenter.getMainData();

  }

  public static void actionStart(Context context) {
    Intent intent = new Intent(context, MainActivity.class);
    context.startActivity(intent);
  }

  @Override
  protected void initInject() {
    DaggerMainComponent.builder().appComponent(MyApp.getAppComponent())
        .mainModule(new MainModule(this)).build().inject(this);
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
  public void setMainData() {
    showShortToast("成功进入主页面啦！");
  }
}

package com.zhiji.phonemall.ui.main;

import android.content.Context;
import android.content.Intent;
import com.zhiji.phonemall.R;
import com.zhiji.phonemall.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainMvpView {


  @Override
  protected int provideLayoutId() {
    return R.layout.activity_main;
  }

  public static void openActivity(Context context) {
    Intent intent = new Intent(context, MainActivity.class);
    context.startActivity(intent);
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

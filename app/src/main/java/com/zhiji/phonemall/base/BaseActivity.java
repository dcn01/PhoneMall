package com.zhiji.phonemall.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.zhiji.phonemall.app.App;
import com.zhiji.phonemall.di.component.ActivityComponent;
import com.zhiji.phonemall.di.component.DaggerActivityComponent;
import com.zhiji.phonemall.di.module.ActivityModule;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/26
 *     desc   :
 * </pre>
 */
public abstract class BaseActivity extends AppCompatActivity {

  private Unbinder mUnbinder;
  private ProgressDialog mProgressDialog;
  private ActivityComponent mActivityComponent;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(provideLayoutId());
    mUnbinder = ButterKnife.bind(this);
    mProgressDialog = new ProgressDialog(this);
    mProgressDialog.setMessage("正在加载中...");
    mActivityComponent = DaggerActivityComponent.builder()
        .appComponent(((App) getApplication()).getAppComponent())
        .activityModule(new ActivityModule(this)).build();
    initInject();
    initView();
  }

  public ActivityComponent getActivityComponent() {
    return mActivityComponent;
  }

  /**
   * 提供布局
   */
  protected abstract int provideLayoutId();

  /**
   * 初始化view
   */
  protected abstract void initView();

  /**
   * Dagger2注入
   */
  protected abstract void initInject();

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mUnbinder.unbind();
  }

  /**
   * 显示加载进度条
   */
  protected void showProgressDialog() {
    if (!mProgressDialog.isShowing()) {
      mProgressDialog.show();
    }
  }

  /**
   * 隐藏加载进度条
   */
  protected void hideProgressDialog() {
    if (mProgressDialog.isShowing()) {
      mProgressDialog.hide();
    }
  }

  /**
   * 显示toast
   */
  protected void showShortToast(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }

  /**
   * 显示toast
   */
  protected void showLongToast(String message) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show();
  }
}

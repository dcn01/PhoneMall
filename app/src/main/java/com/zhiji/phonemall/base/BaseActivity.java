package com.zhiji.phonemall.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/26
 *     desc   :
 * </pre>
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

  protected CompositeDisposable mCompositeDisposable;
  @Inject
  protected P mPresenter;
  protected Unbinder mUnbinder;
  protected ProgressDialog mProgressDialog;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(provideLayoutId());
    mUnbinder = ButterKnife.bind(this);
    mProgressDialog = new ProgressDialog(this);
    mProgressDialog.setMessage("正在加载中...");
    initInject();
    initView();
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
    if (mPresenter != null) {
      mPresenter.detachView();
    }
    unSubscribe();
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

  /**
   * 解除所有的订阅
   */
  protected void unSubscribe() {
    if (mCompositeDisposable != null) {
      mCompositeDisposable.clear();
    }
  }

  protected void addSubscribe(Disposable disposable) {
    if (mCompositeDisposable == null) {
      mCompositeDisposable = new CompositeDisposable();
    }
    mCompositeDisposable.add(disposable);
  }
}

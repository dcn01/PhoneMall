package com.zhiji.phonemall.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/26
 *     desc   :
 * </pre>
 */
public abstract class BaseFragment<P extends MvpPresenter> extends Fragment {

  protected Context mContext;
  protected Unbinder mUnbinder;
  protected ProgressDialog mProgressDialog;
  protected View mContentView;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mContext = getActivity();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    mContentView = LayoutInflater.from(mContext).inflate(provideLayoutId(), container, false);
    mUnbinder = ButterKnife.bind(this, mContentView);
    mProgressDialog = new ProgressDialog(mContext);
    mProgressDialog.setMessage("正在加载中...");
    initView();
    return mContentView;
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
   * 创建Presenter
   */
  protected abstract P createPresenter();

  @Override
  public void onDestroy() {
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
    Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
  }

  /**
   * 显示toast
   */
  protected void showLongToast(String message) {
    Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
  }
}

package com.zhiji.phonemall.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.zhiji.phonemall.di.component.ActivityComponent;
import com.zhiji.phonemall.ui.main.MainActivity;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/26
 *     desc   :
 * </pre>
 */
public abstract class BaseFragment<P extends MvpPresenter> extends Fragment {
  private MainActivity mActivity;
  private boolean mHidden;
  public static final String HIDE_STATE="HideState";
  protected Unbinder mUnbinder;
  protected ProgressDialog mProgressDialog;
  protected View mContentView;

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof MainActivity) {
      MainActivity activity = (MainActivity) context;
      this.mActivity = activity;
    }
  }
  public ActivityComponent getActivityComponent() {
    if (mActivity != null) {
      return mActivity.getActivityComponent();
    }
    return null;
  }
  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if(savedInstanceState!=null){
      mHidden=savedInstanceState.getBoolean(HIDE_STATE);
      FragmentTransaction transaction=getFragmentManager().beginTransaction();
      if(mHidden){
       transaction.hide(this);
      }else{
        transaction.show(this);
      }
      transaction.commit();
    }
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    mContentView = LayoutInflater.from(mActivity).inflate(provideLayoutId(), container, false);
    mUnbinder = ButterKnife.bind(this, mContentView);
    mProgressDialog = new ProgressDialog(mActivity);
    mProgressDialog.setMessage("正在加载中...");
    initInject();
    initView();
    return mContentView;
  }

  protected abstract void initInject();


  /**
   * 提供布局
   */
  protected abstract int provideLayoutId();

  /**
   * 初始化view
   */
  protected abstract void initView();

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
    Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
  }

  /**
   * 显示toast
   */
  protected void showLongToast(String message) {
    Toast.makeText(mActivity, message, Toast.LENGTH_LONG).show();
  }

  /**
   * 用于记住Fragment重启前的状态
   *  @param outState
   */
  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putBoolean(HIDE_STATE,isHidden());

  }

  @Override
  public void onHiddenChanged(boolean hidden) {
    super.onHiddenChanged(hidden);
    String show;
    if(hidden){
      show="隐藏";
    }else{
      show="显示";
    }
    Log.d(getClass().getSimpleName(), "onHiddenChanged: "+show);
  }
}

package com.zhiji.phonemall.ui.home;

import com.zhiji.phonemall.R;
import com.zhiji.phonemall.base.BaseFragment;
import com.zhiji.phonemall.base.MvpPresenter;
import com.zhiji.phonemall.di.component.ActivityComponent;
import javax.inject.Inject;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/08/03
 *     desc   :
 * </pre>
 */
public class HomeFragment extends BaseFragment implements HomeMvpView{

  public static final String TAG_HOME="HomeFragment";

  @Inject
  HomeMvpPresenter<HomeMvpView> mPresenter;
  @Override
  protected void initInject() {
    ActivityComponent activityComponent=getActivityComponent();
    if(activityComponent!=null){
      activityComponent.inject(this);
    }

  }

  @Override
  protected int provideLayoutId() {
    return R.layout.fragment_home;
  }

  @Override
  protected void initView() {
    mPresenter.attachView(this);
    //do something....
    mPresenter.requestHomeData();

  }

  public static HomeFragment newInstance() {
    HomeFragment fragment = new HomeFragment();
    return fragment;
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

  @Override
  public void onDestroy() {
    super.onDestroy();
    mPresenter.detachView();
  }
}

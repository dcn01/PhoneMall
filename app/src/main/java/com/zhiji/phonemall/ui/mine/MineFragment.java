package com.zhiji.phonemall.ui.mine;

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
public class MineFragment extends BaseFragment implements MineMvpView{

  @Inject
  MineMvpPresenter<MineMvpView> mPresenter;
  public static final String TAG_MINE="MineFragment";

  @Override
  protected void initInject() {
    ActivityComponent activityComponent=getActivityComponent();
    if(activityComponent!=null){
      activityComponent.inject(this);
    }
  }

  @Override
  protected int provideLayoutId() {
    return R.layout.fragment_mine;
  }

  @Override
  protected void initView() {
    mPresenter.attachView(this);
    mPresenter.requestMineData();

  }

  public static MineFragment newInstance() {
    MineFragment fragment = new MineFragment();
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
}

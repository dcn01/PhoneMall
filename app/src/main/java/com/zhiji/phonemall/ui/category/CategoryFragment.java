package com.zhiji.phonemall.ui.category;

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
public class CategoryFragment extends BaseFragment implements CategoryMvpView{

  @Inject
  CategoryMvpPresenter<CategoryMvpView> mPresenter;
  public static final String TAG_CATEGORY="CategoryFragment";

  @Override
  protected void initInject() {
    ActivityComponent activityComponent=getActivityComponent();
    if(activityComponent!=null){
      activityComponent.inject(this);
    }
  }

  @Override
  protected int provideLayoutId() {
    return R.layout.fragment_category;
  }

  @Override
  protected void initView() {
    mPresenter.attachView(this);
    mPresenter.requestCategoryData();

  }

  public static CategoryFragment newInstance() {
    CategoryFragment fragment = new CategoryFragment();
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

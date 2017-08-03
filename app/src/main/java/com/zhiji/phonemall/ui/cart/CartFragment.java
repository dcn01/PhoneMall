package com.zhiji.phonemall.ui.cart;

import com.zhiji.phonemall.R;
import com.zhiji.phonemall.base.BaseFragment;
import com.zhiji.phonemall.di.component.ActivityComponent;
import javax.inject.Inject;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/08/03
 *     desc   :
 * </pre>
 */
public class CartFragment extends BaseFragment implements CartMvpView{

  @Inject
  CartMvpPresenter<CartMvpView> mPresenter;
  public static final String TAG_CART="CartFragment";

  @Override
  protected void initInject() {
    ActivityComponent activityComponent=getActivityComponent();
    if(activityComponent!=null){
      activityComponent.inject(this);
    }
  }

  @Override
  protected int provideLayoutId() {
    return R.layout.fragment_cart;
  }

  @Override
  protected void initView() {
    mPresenter.attachView(this);
    mPresenter.requestCartData();

  }

  public static CartFragment newInstance() {
    CartFragment fragment = new CartFragment();
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

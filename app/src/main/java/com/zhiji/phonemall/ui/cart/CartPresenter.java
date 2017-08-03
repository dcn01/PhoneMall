package com.zhiji.phonemall.ui.cart;

import com.zhiji.phonemall.base.BasePresenter;
import com.zhiji.phonemall.data.DataManager;
import com.zhiji.phonemall.ui.category.CategoryMvpView;
import com.zhiji.phonemall.ui.home.HomeMvpPresenter;
import com.zhiji.phonemall.ui.home.HomeMvpView;
import com.zhiji.phonemall.utils.LogUtil;
import com.zhiji.phonemall.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/08/03
 *     desc   :
 * </pre>
 */
public class CartPresenter<V extends CartMvpView> extends BasePresenter<V>implements CartMvpPresenter<V> {

  @Inject
  public CartPresenter(DataManager dataManager,
      CompositeDisposable compositeDisposable,
      SchedulerProvider schedulerProvider) {
    super(dataManager, compositeDisposable, schedulerProvider);
  }

  @Override
  public void requestCartData() {
    LogUtil.d("TAG","请求到购物车数据啦！");
  }
}

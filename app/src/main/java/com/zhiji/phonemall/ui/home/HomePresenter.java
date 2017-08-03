package com.zhiji.phonemall.ui.home;

import com.zhiji.phonemall.base.BasePresenter;
import com.zhiji.phonemall.data.DataManager;
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
public class HomePresenter<V extends HomeMvpView> extends BasePresenter<V>implements HomeMvpPresenter<V> {

  @Inject
  public HomePresenter(DataManager dataManager,
      CompositeDisposable compositeDisposable,
      SchedulerProvider schedulerProvider) {
    super(dataManager, compositeDisposable, schedulerProvider);
  }

  @Override
  public void requestHomeData() {
    LogUtil.d("TAG","请求到主页数据啦！");
  }
}

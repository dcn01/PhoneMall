package com.zhiji.phonemall.ui.mine;

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
public class MinePresenter<V extends MineMvpView> extends BasePresenter<V>implements MineMvpPresenter<V> {

  @Inject
  public MinePresenter(DataManager dataManager,
      CompositeDisposable compositeDisposable,
      SchedulerProvider schedulerProvider) {
    super(dataManager, compositeDisposable, schedulerProvider);
  }

  @Override
  public void requestMineData() {
    LogUtil.d("TAG","请求到我的页面数据啦！");
  }
}

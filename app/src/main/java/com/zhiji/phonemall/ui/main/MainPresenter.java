package com.zhiji.phonemall.ui.main;

import com.zhiji.phonemall.base.BasePresenter;
import com.zhiji.phonemall.data.DataManager;
import com.zhiji.phonemall.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/26
 *     desc   :
 * </pre>
 */
public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

  public MainPresenter(DataManager dataManager,
      CompositeDisposable compositeDisposable,
      SchedulerProvider schedulerProvider) {
    super(dataManager, compositeDisposable, schedulerProvider);
  }
}

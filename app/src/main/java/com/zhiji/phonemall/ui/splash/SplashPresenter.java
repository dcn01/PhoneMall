package com.zhiji.phonemall.ui.splash;

import com.google.gson.Gson;
import com.zhiji.phonemall.base.BasePresenter;
import com.zhiji.phonemall.data.DataManager;
import com.zhiji.phonemall.data.network.model.TestResponse;
import com.zhiji.phonemall.ui.main.MainActivity;
import com.zhiji.phonemall.utils.LogUtil;
import com.zhiji.phonemall.utils.rx.RxUtil;
import com.zhiji.phonemall.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/26
 *     desc   :
 * </pre>
 */
public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V> implements
    SplashMvpPresenter<V> {

  @Inject
  public SplashPresenter(DataManager dataManager,
      CompositeDisposable compositeDisposable,
      SchedulerProvider schedulerProvider) {
    super(dataManager, compositeDisposable, schedulerProvider);
  }

  @Override
  public void requestSplashData() {
    getCompositeDisposable()
        .add(getDataManager().requestSplashData()
            .compose(RxUtil.<TestResponse>rxSchedulerHelper())
            .subscribe(new Consumer<TestResponse>() {
              @Override
              public void accept(TestResponse testResponse) throws Exception {
                LogUtil.d("TAG", new Gson().toJson(testResponse));
                getMvpView().openMainActivity();
              }
            }, new Consumer<Throwable>() {
              @Override
              public void accept(Throwable throwable) throws Exception {
                LogUtil.d("TAG", throwable.getMessage());
              }
            }));
  }
}

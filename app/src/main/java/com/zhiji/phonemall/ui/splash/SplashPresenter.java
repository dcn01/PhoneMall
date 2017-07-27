package com.zhiji.phonemall.ui.splash;

import android.util.Log;
import com.zhiji.phonemall.base.RxPresenter;
import com.zhiji.phonemall.ui.splash.SplashContract.IPresenter;
import com.zhiji.phonemall.ui.splash.SplashContract.IView;
import com.zhiji.phonemall.utils.LogUtil;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/26
 *     desc   :
 * </pre>
 */
public class SplashPresenter extends RxPresenter<IView> implements IPresenter {


  @Inject
  protected SplashPresenter(IView mView) {
    attachView(mView);
  }

  public void getSplashData() {
    Observable.timer(3, TimeUnit.SECONDS)
        .subscribe(new Observer<Long>() {
          @Override
          public void onSubscribe(@NonNull Disposable d) {
            LogUtil.d("TAG", Thread.currentThread().getName());
            addSubscribe(d);
          }

          @Override
          public void onNext(@NonNull Long aLong) {
            mView.setSplashData();
          }

          @Override
          public void onError(@NonNull Throwable e) {

          }

          @Override
          public void onComplete() {

          }
        });
  }
}

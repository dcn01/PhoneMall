package com.zhiji.phonemall.utils.rx;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/28
 *     desc   :
 * </pre>
 */
public class RxUtil {

  public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {//利用Compose简化线程的操作
    return new ObservableTransformer<T, T>() {
      @Override
      public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
        return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
      }
    };
  }

}

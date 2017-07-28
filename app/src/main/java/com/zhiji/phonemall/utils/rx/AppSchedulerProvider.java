package com.zhiji.phonemall.utils.rx;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/28
 *     desc   : RxJava线程控制
 * </pre>
 */
public class AppSchedulerProvider implements SchedulerProvider {

  @Override
  public Scheduler ui() {
    return AndroidSchedulers.mainThread();
  }

  @Override
  public Scheduler io() {
    return Schedulers.io();
  }
}

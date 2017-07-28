package com.zhiji.phonemall.utils.rx;

import io.reactivex.Scheduler;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/28
 *     desc   :
 * </pre>
 */
public interface SchedulerProvider {

  Scheduler ui();

  Scheduler io();
}

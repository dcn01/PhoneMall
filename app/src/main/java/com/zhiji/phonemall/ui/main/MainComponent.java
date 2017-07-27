package com.zhiji.phonemall.ui.main;

import dagger.Component;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/27
 *     desc   :
 * </pre>
 */
@Component(modules = {MainModule.class})
public interface MainComponent {

  void inject(MainActivity activity);
}

package com.zhiji.phonemall.ui.splash;

import com.zhiji.phonemall.di.component.AppComponent;
import com.zhiji.phonemall.di.scope.ActivityScope;
import dagger.Component;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/27
 *     desc   :
 * </pre>
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = {SplashModule.class})
public interface SplashComponent {

  void inject(SplashActivity activity);
}

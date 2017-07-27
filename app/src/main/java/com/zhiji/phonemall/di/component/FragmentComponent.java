package com.zhiji.phonemall.di.component;

import android.app.Activity;
import com.zhiji.phonemall.di.module.ActivityModule;
import com.zhiji.phonemall.di.module.FragmentModule;
import com.zhiji.phonemall.di.scope.ActivityScope;
import com.zhiji.phonemall.di.scope.FragmentScope;
import com.zhiji.phonemall.ui.main.MainActivity;
import com.zhiji.phonemall.ui.splash.SplashActivity;
import dagger.Component;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/26
 *     desc   :
 * </pre>
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

  Activity getActivity();

}

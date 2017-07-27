package com.zhiji.phonemall.di.component;

import android.content.Context;
import com.zhiji.phonemall.app.MyApp;
import com.zhiji.phonemall.di.module.AppModule;
import com.zhiji.phonemall.di.module.HttpModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/27
 *     desc   :
 * </pre>
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

  Context getApplicationContext();

  MyApp getMyApp();

}

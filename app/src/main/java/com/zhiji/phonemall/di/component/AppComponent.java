package com.zhiji.phonemall.di.component;

import android.app.Application;
import android.content.Context;
import com.zhiji.phonemall.app.App;
import com.zhiji.phonemall.data.DataManager;
import com.zhiji.phonemall.di.module.AppModule;
import com.zhiji.phonemall.di.module.HttpModule;
import com.zhiji.phonemall.di.qualifier.ApplicationContext;
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

  void inject(App app);

  @ApplicationContext
  Context getContext();

  Application getApplication();

  DataManager getDataManager();
}

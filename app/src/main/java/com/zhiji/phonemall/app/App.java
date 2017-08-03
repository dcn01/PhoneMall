package com.zhiji.phonemall.app;

import android.app.Activity;
import android.app.Application;
import com.zhiji.phonemall.data.DataManager;
import com.zhiji.phonemall.di.component.AppComponent;
import com.zhiji.phonemall.di.component.DaggerAppComponent;
import com.zhiji.phonemall.di.module.AppModule;
import com.zhiji.phonemall.di.module.HttpModule;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/26
 *     desc   :
 * </pre>
 */
public class App extends Application {

  public static App mInstance;
  private AppComponent mAppComponent;
  private Set<Activity> mActivitySet;
  @Inject
  DataManager mDataManager;

  @Override
  public void onCreate() {
    super.onCreate();
    mInstance = this;
    //注入DataManager
    mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this))
        .httpModule(new HttpModule()).build();
    mAppComponent.inject(this);
  }


  public AppComponent getAppComponent() {
    return mAppComponent;
  }

  public void addActivity(Activity activity) {
    if (mActivitySet == null) {
      mActivitySet = new HashSet<>();
    }
    mActivitySet.add(activity);
  }

  public void removeActivity(Activity activity) {
    if (mActivitySet != null) {
      mActivitySet.remove(activity);
    }
  }

  public void exitApp() {
    if (mActivitySet != null) {
      synchronized (mActivitySet) {
        for (Activity activity : mActivitySet) {
          activity.finish();
        }
      }
    }
    android.os.Process.killProcess(android.os.Process.myPid());
    System.exit(0);

  }


}

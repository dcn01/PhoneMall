package com.zhiji.phonemall.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.zhiji.phonemall.di.scope.FragmentScope;
import dagger.Module;
import dagger.Provides;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/26
 *     desc   :
 * </pre>
 */
@Module
public class FragmentModule {

  private Fragment mFragment;

  public FragmentModule(Fragment mFragment) {
    this.mFragment = mFragment;
  }

  @Provides
  @FragmentScope
  Activity provideActivity() {
    return mFragment.getActivity();
  }
}

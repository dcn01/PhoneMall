package com.zhiji.phonemall.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/08/04
 *     desc   : Fragment懒加载模式实现，一般配合ViewPager使用
 * </pre>
 */
public abstract class LazyFragment extends Fragment {

  private boolean isViewCreated;//标志view已经创建完成
  private boolean isDataLoaded;//标志数据已经加载过了

  /**
   * 注意此方法的调用在onCreateView前
   */
  @Override
  public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);
    prepareData(false);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return super.onCreateView(inflater, container, savedInstanceState);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    isViewCreated = true;
    prepareData(false);
  }

  /**
   * 准备数据
   */
  private void prepareData(boolean isForceLoadData) {
    if (getUserVisibleHint() && isViewCreated && !(isDataLoaded||isForceLoadData)) {
      //对用户可见，view初始化完成，数据没有被加载过,isForceLoadData代表每次进入页面都重新请求数据
      //do something 请求数据
      isDataLoaded=true;
    }
  }


}

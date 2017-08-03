package com.zhiji.phonemall.ui.category;

import com.zhiji.phonemall.base.BasePresenter;
import com.zhiji.phonemall.data.DataManager;
import com.zhiji.phonemall.ui.category.CategoryMvpPresenter;
import com.zhiji.phonemall.ui.category.CategoryMvpView;
import com.zhiji.phonemall.utils.LogUtil;
import com.zhiji.phonemall.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/08/03
 *     desc   :
 * </pre>
 */
public class CategoryPresenter<V extends CategoryMvpView> extends BasePresenter<V>implements
    CategoryMvpPresenter<V> {

  @Inject
  public CategoryPresenter(DataManager dataManager,
      CompositeDisposable compositeDisposable,
      SchedulerProvider schedulerProvider) {
    super(dataManager, compositeDisposable, schedulerProvider);
  }

  @Override
  public void requestCategoryData() {
    LogUtil.d("TAG","请求到分类数据啦！");
  }
}

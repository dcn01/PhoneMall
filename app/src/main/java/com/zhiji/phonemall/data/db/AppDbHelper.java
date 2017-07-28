package com.zhiji.phonemall.data.db;

import com.zhiji.phonemall.data.db.model.DaoMaster;
import com.zhiji.phonemall.data.db.model.DaoSession;
import com.zhiji.phonemall.data.db.model.User;
import io.reactivex.Observable;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/28
 *     desc   :
 * </pre>
 */
@Singleton
public class AppDbHelper implements DbHelper {

  private final DaoSession mDaoSession;
  @Inject
  public AppDbHelper(DbOpenHelper dbOpenHelper) {
    mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
  }

  @Override
  public Observable<Long> insertUser(final User user) {
    return Observable.fromCallable(new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        return mDaoSession.getUserDao().insert(user);
      }
    });
  }
}

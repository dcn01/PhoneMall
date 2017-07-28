package com.zhiji.phonemall.data.db;

import android.content.Context;
import com.zhiji.phonemall.data.db.model.DaoMaster;
import com.zhiji.phonemall.di.qualifier.ApplicationContext;
import com.zhiji.phonemall.di.qualifier.DatabaseInfo;
import com.zhiji.phonemall.utils.LogUtil;
import javax.inject.Inject;
import org.greenrobot.greendao.database.Database;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/28
 *     desc   :
 * </pre>
 */
public class DbOpenHelper extends DaoMaster.OpenHelper {

  @Inject
  public DbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
    super(context, name);
  }

  @Override
  public void onUpgrade(Database db, int oldVersion, int newVersion) {
    super.onUpgrade(db, oldVersion, newVersion);
    LogUtil.d("DEBUG", "DB_OLD_VERSION : " + oldVersion + ", DB_NEW_VERSION : " + newVersion);
    switch (oldVersion) {
      case 1:
      case 2:
        //db.execSQL("ALTER TABLE " + UserDao.TABLENAME + " ADD COLUMN "
        // + UserDao.Properties.Name.columnName + " TEXT DEFAULT 'DEFAULT_VAL'");
    }
  }
}

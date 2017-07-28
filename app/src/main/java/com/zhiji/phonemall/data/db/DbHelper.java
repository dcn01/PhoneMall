package com.zhiji.phonemall.data.db;

import com.zhiji.phonemall.data.db.model.User;
import io.reactivex.Observable;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/28
 *     desc   : 数据库操作接口
 * </pre>
 */
public interface DbHelper {

  Observable<Long> insertUser(User user);
}

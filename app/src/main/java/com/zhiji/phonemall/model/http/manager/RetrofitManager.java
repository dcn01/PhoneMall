package com.zhiji.phonemall.model.http.manager;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * <pre>
 *     author : llj
 *     time   : 2017/07/27
 *     desc   :
 * </pre>
 */
public class RetrofitManager {

  private final List<Call> mCallList;

  public RetrofitManager(List<Call> callList) {
    mCallList = callList;
  }

  public <T> void call(Call<T> call, Callback<T> callback) {
    addCall(call);
    call.enqueue(callback);
  }

  public <T> Response<T> call(Call<T> call) throws IOException {
    addCall(call);
    return call.execute();
  }

  private void addCall(Call call) {
    synchronized (mCallList) {
      mCallList.add(call);
    }
  }

  public void cancelAll() {
    synchronized (mCallList) {
      Iterator<Call> iterator = mCallList.iterator();
      while (iterator.hasNext()) {
        Call call = iterator.next();
        if (call == null || call.isCanceled()) {
          continue;
        }
        call.cancel();
        iterator.remove();
      }
    }
  }
}

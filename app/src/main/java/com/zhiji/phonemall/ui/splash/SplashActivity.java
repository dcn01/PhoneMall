package com.zhiji.phonemall.ui.splash;

import android.widget.Button;

import com.zhiji.phonemall.R;
import com.zhiji.phonemall.base.BaseActivity;
import com.zhiji.phonemall.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class SplashActivity extends BaseActivity implements SplashMvpView {

    @Inject
    SplashMvpPresenter<SplashMvpView> mPresenter;
    private static final String TAG = "SplashActivity";
    @BindView(R.id.btn_jump)
    Button mBtnJump;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_splash;
    }

    @OnClick(R.id.btn_jump)
    public void jumpMain(){
        //断开RxJava
        if(mPresenter instanceof SplashPresenter){
            ((SplashPresenter)mPresenter).getCompositeDisposable().dispose();
        }
        MainActivity.openActivity(this);
        finish();

    }
    @Override
    protected void initView() {
        mPresenter.attachView(this);
        //do something...
        mPresenter.requestSplashData();
    }

    /**
     * 利用Dagger2注入Presenter
     */
    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void showLoading() {
        showProgressDialog();

    }

    @Override
    public void hideLoading() {
        hideProgressDialog();

    }

    @Override
    public void showMessage(String msg) {
        showShortToast(msg);
    }

    @Override
    public void openLoginActivity() {

    }

    @Override
    public void openMainActivity() {
        MainActivity.openActivity(this);
        finish();
    }

    @Override
    public void showTime(String time) {
        mBtnJump.setText("跳过\n" + time + "s");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}

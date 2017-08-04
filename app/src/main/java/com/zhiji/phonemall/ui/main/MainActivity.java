package com.zhiji.phonemall.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationBar.OnTabSelectedListener;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.zhiji.phonemall.R;
import com.zhiji.phonemall.app.App;
import com.zhiji.phonemall.base.BaseFragment;
import com.zhiji.phonemall.di.component.ActivityComponent;
import com.zhiji.phonemall.di.component.DaggerActivityComponent;
import com.zhiji.phonemall.di.module.ActivityModule;
import com.zhiji.phonemall.ui.cart.CartFragment;
import com.zhiji.phonemall.ui.category.CategoryFragment;
import com.zhiji.phonemall.ui.home.HomeFragment;
import com.zhiji.phonemall.ui.mine.MineFragment;
import com.zhiji.phonemall.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityComponent mActivityComponent;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;
    private List<BaseFragment> mFragmentList;
    private BaseFragment mFragment;//记录正在显示的Fragment
    private int mPosition;//记录集合中Fragment的位置

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initBottomNavigationBar();
        mActivityComponent = DaggerActivityComponent.builder()
                .appComponent(((App) getApplication()).getAppComponent())
                .activityModule(new ActivityModule(this)).build();
        if (savedInstanceState != null) {
            //说明是配置变化或者低内存重启等导致的Activity重建，这里处理Fragment可能导致的重叠问题
            //获取到Activity重建后，FragmentManager保存的Fragment
            getRestoreFragment();
            String fragmentTag = getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE).getString("tag", null);
            if (fragmentTag != null) {
                mFragment= (BaseFragment) getSupportFragmentManager().findFragmentByTag(fragmentTag);
               switch (fragmentTag){
                   case HomeFragment.TAG_HOME:
                       showRestoreFragment(1,2,3);
                       break;
                   case CategoryFragment.TAG_CATEGORY:
                       showRestoreFragment(0,2,3);
                       break;
                   case CartFragment.TAG_CART:
                       showRestoreFragment(0,1,3);
                       break;
                   case MineFragment.TAG_MINE:
                       showRestoreFragment(0,1,2);
                       break;
                   default:
                       break;
               }
            }

        } else {
            //正常状态下的生命周期
            initFragment();
            BaseFragment currentFragment = mFragmentList.get(0);
            switchFragment(mFragment, currentFragment);

        }
    }
    private void showRestoreFragment(int var1,int var2,int var3){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        if(mFragmentList.get(var1).isAdded()){
            transaction.hide(mFragmentList.get(var1));
        }
        if(mFragmentList.get(var2).isAdded()){
            transaction.hide(mFragmentList.get(var2));
        }
        if(mFragmentList.get(var3).isAdded()){
            transaction.hide(mFragmentList.get(var3));
        }
        if(mFragment.isHidden()){
            transaction.show(mFragment).commit();
        }

    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    /**
     * 显示内存重启后的恢复的Fragment
     */
    private void getRestoreFragment() {
        mFragmentList = new ArrayList<>();
        FragmentManager fm = getSupportFragmentManager();
        if (fm.findFragmentByTag(HomeFragment.TAG_HOME) == null) {
            mFragmentList.add(HomeFragment.newInstance());
        } else {
            mFragmentList.add((HomeFragment) fm.findFragmentByTag(HomeFragment.TAG_HOME));
        }
        if (fm.findFragmentByTag(CategoryFragment.TAG_CATEGORY) == null) {
            mFragmentList.add(CategoryFragment.newInstance());
        } else {
            mFragmentList.add((CategoryFragment) fm.findFragmentByTag(CategoryFragment.TAG_CATEGORY));
        }
        if (fm.findFragmentByTag(CartFragment.TAG_CART) == null) {
            mFragmentList.add(CartFragment.newInstance());
        } else {
            mFragmentList.add((CartFragment) fm.findFragmentByTag(CartFragment.TAG_CART));
        }
        if (fm.findFragmentByTag(MineFragment.TAG_MINE) == null) {
            mFragmentList.add(MineFragment.newInstance());
        } else {
            mFragmentList.add((MineFragment) fm.findFragmentByTag(MineFragment.TAG_MINE));
        }

    }

    private void initBottomNavigationBar() {
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.setActiveColor(R.color.bottom_active);
        mBottomNavigationBar.setInActiveColor(R.color.bottom_not_active);
        mBottomNavigationBar.setBarBackgroundColor(R.color.bottom_background);
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.home, "首页"))
                .addItem(new BottomNavigationItem(R.mipmap.category, "分类"))
                .addItem(new BottomNavigationItem(R.mipmap.cart, "购物车"))
                .addItem(new BottomNavigationItem(R.mipmap.mine, "我的"))
                .setFirstSelectedPosition(0)
                .initialise();
        mBottomNavigationBar.setTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case 0:
                        mPosition = 0;
                        break;
                    case 1:
                        mPosition = 1;
                        break;
                    case 2:
                        mPosition = 2;
                        break;
                    case 3:
                        mPosition = 3;
                        break;
                    default:
                        mPosition = 0;
                        break;
                }
                BaseFragment currentFragment = mFragmentList.get(mPosition);
                switchFragment(mFragment, currentFragment);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    private void initFragment() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(HomeFragment.newInstance());
        mFragmentList.add(CategoryFragment.newInstance());
        mFragmentList.add(CartFragment.newInstance());
        mFragmentList.add(MineFragment.newInstance());
    }

    private void switchFragment(BaseFragment lastFragment, BaseFragment currentFragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if (lastFragment != currentFragment) {
            //说明切换了Fragment,更新当前的Fragment
            mFragment = currentFragment;
            if (lastFragment != null) {
                transaction.hide(lastFragment);
            }
            if (!currentFragment.isAdded()) {
                transaction.add(R.id.main_container, currentFragment, currentFragment.getClass().getSimpleName()).commit();
            } else {
                transaction.show(currentFragment).commit();
            }

        }
    }

    public static void openActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }


}

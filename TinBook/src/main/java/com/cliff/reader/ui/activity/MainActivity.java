package com.cliff.reader.ui.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.cliff.reader.R;
import com.cliff.reader.base.BaseActivity;
import com.cliff.reader.base.Constant;
import com.cliff.reader.bean.user.TencentLoginResult;
import com.cliff.reader.component.AppComponent;
import com.cliff.reader.component.DaggerMainComponent;
import com.cliff.reader.manager.EventManager;
import com.cliff.reader.manager.SettingManager;
import com.cliff.reader.ui.contract.MainContract;
import com.cliff.reader.ui.fragment.RecommendFragment;
import com.cliff.reader.ui.presenter.MainActivityPresenter;
import com.cliff.reader.utils.LogUtils;
import com.cliff.reader.utils.SharedPreferencesUtil;
import com.cliff.reader.utils.ToastUtils;
import com.cliff.reader.view.GenderPopupWindow;
import com.cliff.reader.view.LoginPopupWindow;
import com.cliff.reader.view.RVPIndicator;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/***
 * 项目名称： Tin看书
 * 类名：MainActivity
 * 类描述：主页
 * 作者：Administrator  
 * 创建时间：2018/2/9  10:56 
 * 版本号：1.0.0
 *
*/
public class MainActivity extends BaseActivity implements MainContract.View , LoginPopupWindow.LoginTypeListener{

    @Bind(R.id.indicator)
    RVPIndicator mIndicator;

    @Bind(R.id.viewpager)
    ViewPager mViewPager;

    private List<String> mDatas;
    private List<Fragment> mTabContents;
    private FragmentPagerAdapter mAdapter;

    @Inject
    MainActivityPresenter mPresenter;

    private GenderPopupWindow genderPopupWindow;

    private LoginPopupWindow loginPopupWindow;



    /***
     * 布局文件
     *
     * @return
     */
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    /***
     * 初始化数据
     */
    @Override
    public void initDatas() {
        mDatas = Arrays.asList(getResources().getStringArray(R.array.home_tabs));
        mTabContents = new ArrayList<>();
        mTabContents.add(new RecommendFragment());
        mTabContents.add(new RecommendFragment());
        mTabContents.add(new RecommendFragment());

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mTabContents.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mTabContents.get(position);
            }
        };


    }

    /**
     * 对各种控件进行设置、适配、填充数据
     */
    @Override
    public void configViews() {
        mIndicator.setTabItemTitles(mDatas);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(3);
        mIndicator.setViewPager(mViewPager, 0);

        mPresenter.attachView(this);

        mIndicator.postDelayed(new Runnable() {
            @Override
            public void run() {
//                showChooseSexPopupWindow();
            }
        }, 500);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_search:
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
                break;
            case R.id.action_login:
                if (loginPopupWindow == null) {
                    loginPopupWindow = new LoginPopupWindow(this);
                    loginPopupWindow.setLoginTypeListener(this);
                }
                loginPopupWindow.showAtLocation(mCommonToolbar, Gravity.CENTER, 0, 0);
                break;
            case R.id.action_my_message:
//                if (popupWindow == null) {
//                    popupWindow = new LoginPopupWindow(this);
//                    popupWindow.setLoginTypeListener(this);
//                }
//                popupWindow.showAtLocation(mCommonToolbar, Gravity.CENTER, 0, 0);
                break;
            case R.id.action_sync_bookshelf:
                showDialog();
                mPresenter.syncBookShelf();
               /* if (popupWindow == null) {
                    popupWindow = new LoginPopupWindow(this);
                    popupWindow.setLoginTypeListener(this);
                }
                popupWindow.showAtLocation(mCommonToolbar, Gravity.CENTER, 0, 0);*/
                break;
            case R.id.action_scan_local_book:
                ScanLocalBookActivity.startActivity(this);
                break;
            case R.id.action_wifi_book:
//                WifiBookActivity.startActivity(this);
                break;
            case R.id.action_feedback:
//                FeedbackActivity.startActivity(this);
                break;
            case R.id.action_night_mode:
                if (SharedPreferencesUtil.getInstance().getBoolean(Constant.ISNIGHT, false)) {
                    SharedPreferencesUtil.getInstance().putBoolean(Constant.ISNIGHT, false);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    SharedPreferencesUtil.getInstance().putBoolean(Constant.ISNIGHT, true);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                recreate();
                break;
            case R.id.action_settings:
//                SettingActivity.startActivity(this);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void showChooseSexPopupWindow() {
        if (genderPopupWindow == null) {
            genderPopupWindow = new GenderPopupWindow(MainActivity.this);
        }
        if (!SettingManager.getInstance().isUserChooseSex()
                && !genderPopupWindow.isShowing()) {
            genderPopupWindow.showAtLocation(mCommonToolbar, Gravity.CENTER, 0, 0);
        }
    }


    /***
     * 设置app组件
     *
     * @param appComponent
     */
    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    /***
     * 初始化toolBar
     */
    @Override
    public void initToolBar() {
//        mCommonToolbar.setLogo(R.mipmap.ic_launcher);
        setTitle(getString(R.string.app_name));
    }


    @Override
    public void loginSuccess() {
        ToastUtils.showSingleToast("登陆成功");
    }

    /***
     * 同步书架成功
     */
    @Override
    public void syncBookShelfCompleted() {
        dismissDialog();
        EventManager.refreshCollectionList();
    }

    @Override
    public void showError() {
        ToastUtils.showSingleToast("同步异常");
        dismissDialog();
    }

    @Override
    public void complete() {

    }


    public void setCurrentItem(int position) {
        mViewPager.setCurrentItem(position);
    }



    @Override
    public void onBackPressed() {
        //实现Home键效果，super.onBackPressed();这句话一定要注掉,不然又去调用默认的back处理方式了
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addCategory(Intent.CATEGORY_HOME);
        startActivity(i);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        System.out.println("Page01 -->onKeyDown: keyCode: " + keyCode);
        if (KeyEvent.KEYCODE_HOME == keyCode||KeyEvent.KEYCODE_BACK==keyCode) {
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            home.addCategory(Intent.CATEGORY_HOME);
            startActivity(home);
            return true;
        }
        return super.onKeyDown(keyCode, event); // 不会回到 home 页面
    }

    @Override
    public void onLogin(LoginPopupWindow.LoginType loginType, String...strings) {
        if(loginType== LoginPopupWindow.LoginType.LoginForAccount){
            mPresenter.login(strings[0],strings[1]);
        }else {

        }

    }



}

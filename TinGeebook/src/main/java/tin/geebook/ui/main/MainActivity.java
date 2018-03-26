package tin.geebook.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import tin.geebook.R;
import tin.geebook.base.BaseActivity;

/**
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG              #
 * #                                                   #
 */

/**
 * 类名：MainActivity.java<br>
 * 描述： 主页<br>
 * 创建者： T_Xin<br>
 * 创建日期：2016-11-10<br>
 * 版本： <br>
 * 修改者： <br>
 * 修改日期：<br>
 */
public class MainActivity extends BaseActivity implements MainContract.IMainView {

    @InjectView(R.id.fl_content)
    FrameLayout flContent;
    @InjectView(R.id.iv_library)
    ImageView ivLibrary;
    @InjectView(R.id.tv_library)
    TextView tvLibrary;
    @InjectView(R.id.ll_library)
    LinearLayout llLibrary;
    @InjectView(R.id.iv_borrow)
    ImageView ivBorrow;
    @InjectView(R.id.tv_borrow)
    TextView tvBorrow;
    @InjectView(R.id.ll_borrow)
    LinearLayout llBorrow;
    @InjectView(R.id.iv_find)
    ImageView ivFind;
    @InjectView(R.id.tv_find)
    TextView tvFind;
    @InjectView(R.id.ll_find)
    LinearLayout llFind;
    @InjectView(R.id.iv_me)
    ImageView ivMe;
    @InjectView(R.id.tv_me)
    TextView tvMe;
    @InjectView(R.id.ll_me)
    LinearLayout llMe;
    @InjectView(R.id.ll_menu_layout)
    LinearLayout llMenuLayout;
    @InjectView(R.id.ll_main_layout)
    LinearLayout llMainLayout;

    MainPresenter mainPresenter;

    public static void actionView(Activity mContext) {
        Intent intent = new Intent(mContext, MainActivity.class);
        intent.putExtra("from", "Splash");
        mContext.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.inject(this);
        mainPresenter=new MainPresenter(this);
        mainPresenter.queryLocationBook();

    }


    @OnClick({R.id.ll_library, R.id.ll_borrow, R.id.ll_find, R.id.ll_me})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_library://藏书
                mainPresenter.clickLibrary();
                break;
            case R.id.ll_borrow://借阅
                mainPresenter.clickBorrow();
                break;
            case R.id.ll_find://发现
                mainPresenter.clickFind();
                break;
            case R.id.ll_me://我的
                mainPresenter.clickMe();
                break;
        }
    }



    /**
     * 显示藏书
     */
    @Override
    public void showLibrary() {

    }

    /***
     * 显示借阅
     */
    @Override
    public void showBorrow() {

    }

    /***
     * 显示发现
     */
    @Override
    public void showFind() {

    }

    /***
     * 显示我的
     */
    @Override
    public void showMe() {

    }



}

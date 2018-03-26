package tin.geebook.ui.splash;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import tin.geebook.R;
import tin.geebook.base.BaseActivity;
import tin.geebook.ui.main.MainActivity;
import tin.geebook.utils.TimeUtils;

/**
 * Created by Administrator on 2018/3/23.
 */
public class SplashActivity extends BaseActivity implements SplashContract.ISplashView{

    @InjectView(R.id.iv_theme)
    ImageView ivTheme;
    @InjectView(R.id.iv_logo)
    ImageView ivLogo;
    @InjectView(R.id.iv_bg)
    ImageView ivBg;
    @InjectView(R.id.iv_thirdMark)
    ImageView ivThirdMark;

    SplashPresenter splashPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        ButterKnife.inject(this);
        splashPresenter=new SplashPresenter(this);
        showSplash();
        splashPresenter.querySplashImg();

    }


    public void showSplash() {
        int timeHour = Integer.parseInt(TimeUtils.getNowDate("HH"));
        if ((timeHour >= 3 && timeHour < 5)) {
            ivTheme.setImageResource(R.drawable.splash_image_3_5);
        } else if ((timeHour >= 5 && timeHour < 10)) {
            ivTheme.setImageResource(R.drawable.splash_image_5_10);
        } else if ((timeHour >= 10 && timeHour < 14)) {
            ivTheme.setImageResource(R.drawable.splash_image_10_14);
        } else if ((timeHour >= 14 && timeHour < 17)) {
            ivTheme.setImageResource(R.drawable.splash_image_14_17);
        } else if ((timeHour >= 17 && timeHour < 20)) {
            ivTheme.setImageResource(R.drawable.splash_image_17_20);
        } else if ((timeHour >= 20 && timeHour < 24)) {
            ivTheme.setImageResource(R.drawable.splash_image_20_00);
        } else if (timeHour >= 0 || timeHour < 3) {
            ivTheme.setImageResource(R.drawable.splash_image_0_3);
        }

        AlphaAnimation animation2 = new AlphaAnimation(0.0f, 1.0f);
        animation2.setDuration(3000);
        animation2.setFillAfter(true);
        ivLogo.startAnimation(animation2);

        AlphaAnimation animation1 = new AlphaAnimation(1.0f, 0.0f);
        animation1.setDuration(2000);
        animation1.setFillAfter(true);
        ivBg.startAnimation(animation1);

        AlphaAnimation animation3 = new AlphaAnimation(0.0f, 1.0f);
        animation3.setDuration(3000);
        animation3.setFillAfter(true);
        ivTheme.startAnimation(animation3);

        ScaleAnimation animation4 = new ScaleAnimation(1f, 1.03f, 1f, 1.03f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation4.setDuration(3000);
        animation4.setFillAfter(true);
        ivTheme.startAnimation(animation4);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.actionView(SplashActivity.this);
                finish();
            }
        },3000);

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}

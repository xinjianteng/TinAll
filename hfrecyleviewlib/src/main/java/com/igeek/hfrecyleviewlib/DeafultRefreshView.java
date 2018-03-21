package com.igeek.hfrecyleviewlib;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.igeek.hfrecyleviewlib.utils.DensityUtils;

public class DeafultRefreshView extends LinearLayout implements IPullRefreshView {

    private ImageView icon;
    private TextView text;
    private MaterialProgressDrawable mProgress;

    public DeafultRefreshView(Context context) {
        this(context, null);
    }

    public DeafultRefreshView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setGravity(Gravity.CENTER);
        setOrientation(HORIZONTAL);

        if (icon == null) {
            DisplayMetrics dm = context.getResources().getDisplayMetrics();

//            LayoutParams lp = new LayoutParams(dm.widthPixels / 10, dm.widthPixels / 10);
            int v = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 42, getResources().getDisplayMetrics());
//            LayoutParams lp = new LayoutParams(dm.widthPixels / 10, dm.widthPixels / 10);
            LayoutParams lp = new LayoutParams(v, v);
            icon = new ImageView(getContext());
            int CIRCLE_BG_LIGHT = 0x66FAFAFA;
            mProgress = new MaterialProgressDrawable(getContext(), icon);
            mProgress.setColorSchemeColors(Color.BLACK);
            mProgress.updateSizes(MaterialProgressDrawable.LARGE);
            mProgress.setAlpha((int) (200));
            mProgress.showArrow(true);
            mProgress.setBackgroundColor(CIRCLE_BG_LIGHT);
            icon.setImageDrawable(mProgress);
            addView(icon, lp);
        }

        if (text == null) {
            LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            lp.leftMargin = DensityUtils.dp2px(8);
            text = new TextView(getContext());
            text.setTextSize(14);
            text.setTextColor(Color.BLACK);
            text.setText(R.string.pulling);
            addView(text, lp);
        }

        text.setVisibility(GONE);
    }

    @Override
    public void onPullHided() {
        icon.setVisibility(VISIBLE);
        if (mProgress != null)
            mProgress.stop();
        text.setText(R.string.pulling);
    }

    @Override
    public void onPullRefresh() {
        isPullDowning = false;
        icon.setVisibility(VISIBLE);

        mProgress.start();
        text.setText(R.string.pulling_refreshing);
    }

    @Override
    public void onPullFreeHand() {
        icon.setVisibility(VISIBLE);
        text.setText(R.string.pulling_refresh);
    }

    private boolean isPullDowning = false;

    @Override
    public void onPullDowning() {
        isPullDowning = true;
        icon.setVisibility(VISIBLE);
        mProgress.showArrow(true);
        text.setText(R.string.pulling);
    }

    //放开手指头刷新完成后
    @Override
    public void onPullFinished() {
        icon.setVisibility(GONE);
        text.setText(R.string.pulling_refreshfinish);
    }

    //执行中
    @Override
    public void onPullProgress(float pullDistance, float pullProgress) {
        if (isPullDowning) {
            mProgress.setStartEndTrim(0f, pullProgress * 0.8f);//圈圈周长，0f-1F
            mProgress.setArrowScale(pullProgress * 1.3f); //箭头大小，0f-1F
            mProgress.setProgressRotation(0.875f + 0.5f * pullProgress); //圈圈的旋转角度
        }
    }
}

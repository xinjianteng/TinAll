package com.cliff.reader.manager.setting;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.cliff.reader.R;
import com.cliff.reader.base.Constant;
import com.cliff.reader.bean.support.ReadTheme;
import com.cliff.reader.utils.AppUtils;
import com.cliff.reader.utils.ScreenUtils;
import com.cliff.reader.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 阅读器背景设置管理
 * @author Tin.
 * @date 2017/12/27.
 */
public class ReadThemeManager {

    public static final int NORMAL = 0;
    public static final int YELLOW = 1;
    public static final int GREEN = 2;
    public static final int LEATHER = 3;
    public static final int GRAY = 4;
    public static final int NIGHT = 5;

    private volatile static ReadThemeManager bookMarksManager;

    public static ReadThemeManager getInstance() {
        return bookMarksManager != null ? bookMarksManager : (bookMarksManager = new ReadThemeManager());
    }

    public void saveReadTheme(int theme) {
        SharedPreferencesUtil.getInstance().putInt("readTheme", theme);
    }

    public int getReadTheme() {
        if (SharedPreferencesUtil.getInstance().getBoolean(Constant.ISNIGHT, false)) {
            return NIGHT;
        }
        return SharedPreferencesUtil.getInstance().getInt("readTheme", 3);
    }


    public  void setReaderTheme(int theme, View view) {
        switch (theme) {
            case NORMAL:
                view.setBackgroundResource(R.drawable.theme_white_bg);
                break;
            case YELLOW:
                view.setBackgroundResource(R.drawable.theme_yellow_bg);
                break;
            case GREEN:
                view.setBackgroundResource(R.drawable.theme_green_bg);
                break;
            case LEATHER:
                view.setBackgroundResource(R.drawable.theme_leather_bg);
                break;
            case GRAY:
                view.setBackgroundResource(R.drawable.theme_gray_bg);
                break;
            case NIGHT:
                view.setBackgroundResource(R.drawable.theme_night_bg);
                break;
            default:
                break;
        }
    }

    public  Bitmap getThemeDrawable(int theme) {
        Bitmap bmp = Bitmap.createBitmap(ScreenUtils.getScreenWidth(), ScreenUtils.getScreenHeight(), Bitmap.Config.ARGB_8888);
        switch (theme) {
            case NORMAL:
                bmp.eraseColor(ContextCompat.getColor(AppUtils.getAppContext(), R.color.read_theme_white));
                break;
            case YELLOW:
                bmp.eraseColor(ContextCompat.getColor(AppUtils.getAppContext(), R.color.read_theme_yellow));
                break;
            case GREEN:
                bmp.eraseColor(ContextCompat.getColor(AppUtils.getAppContext(), R.color.read_theme_green));
                break;
            case LEATHER:
                bmp = BitmapFactory.decodeResource(AppUtils.getAppContext().getResources(), R.drawable.theme_leather_bg);
                break;
            case GRAY:
                bmp.eraseColor(ContextCompat.getColor(AppUtils.getAppContext(), R.color.read_theme_gray));
                break;
            case NIGHT:
                bmp.eraseColor(ContextCompat.getColor(AppUtils.getAppContext(), R.color.read_theme_night));
                break;
            default:
                break;
        }
        return bmp;
    }

    public  List<ReadTheme> getReaderThemeData(int curTheme) {
        int[] themes = {NORMAL, YELLOW, GREEN, LEATHER, GRAY, NIGHT};
        List<ReadTheme> list = new ArrayList<>();
        ReadTheme theme;
        for (int i = 0; i < themes.length; i++) {
            theme = new ReadTheme();
            theme.theme = themes[i];
            list.add(theme);
        }
        return list;
    }
}

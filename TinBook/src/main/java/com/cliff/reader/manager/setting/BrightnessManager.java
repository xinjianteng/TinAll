package com.cliff.reader.manager.setting;

import com.cliff.reader.manager.SettingManager;
import com.cliff.reader.utils.AppUtils;
import com.cliff.reader.utils.ScreenUtils;
import com.cliff.reader.utils.SharedPreferencesUtil;

/**
 *
 * 阅读器亮度设置管理
 * @author Tin.
 * @date 2017/12/27.
 */
public class BrightnessManager {

    private volatile static BrightnessManager brightnessManager;

    public static BrightnessManager getInstance() {
        return brightnessManager != null ? brightnessManager : (brightnessManager = new BrightnessManager());
    }


    /***
     * 获取阅读界面屏幕亮度
     * @return
     */
    public int getReadBrightness() {
        return SharedPreferencesUtil.getInstance().getInt(getLightnessKey(),
                (int) ScreenUtils.getScreenBrightness(AppUtils.getAppContext()));
    }

    /**
     * 保存阅读界面屏幕亮度
     *
     * @param percent 亮度比例 0~100
     */
    public void saveReadBrightness(int percent) {
        SharedPreferencesUtil.getInstance().putInt(getLightnessKey(), percent);
    }

    private String getLightnessKey() {
        return "readLightness";
    }



    public void saveAutoBrightness(boolean enable) {
        SharedPreferencesUtil.getInstance().putBoolean("autoBrightness", enable);
    }

    public boolean isAutoBrightness() {
        return SharedPreferencesUtil.getInstance().getBoolean("autoBrightness", false);
    }


}

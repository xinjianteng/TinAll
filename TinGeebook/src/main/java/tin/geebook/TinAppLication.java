package tin.geebook;

import android.app.Application;

import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Created by Administrator on 2018/3/22.
 */

public class TinAppLication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

//        默认使用的高度是设备的可用高度，也就是不包括状态栏和底部的操作栏的，如果你希望拿设备的物理高度进行百分比化：
        AutoLayoutConifg.getInstance().useDeviceSize();
    }

}

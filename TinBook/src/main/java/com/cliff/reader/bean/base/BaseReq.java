package com.cliff.reader.bean.base;

import android.os.Build;
import android.provider.Settings;

import com.cliff.reader.utils.AppUtils;
import com.cliff.reader.utils.DeviceUtils;

/***
 * 项目名称： Tin看书
 * 类名：BaseReq
 * 类描述：
 * 作者：Administrator
 * 创建时间：2018/2/9  11:27
 * 版本号：1.0.0
 *
*/
public class BaseReq {

    public String optSystem;//=android6.0&
    public String screen;//=1080 * 1812&
    //终端类型(1Android手机、2Android平板、3PC、4IOS手机、5IOS平板、6WEB)
    public String terminalType;//1&
    // 手机唯一码
    public String terminalSn;//863991037248438ef4b7235c5fdccd0
    //终端厂商
    public String terminalFactory;//HUAWEI&

    //终端型号
    public String terminalModel;//HUAWEI VNS-AL00&

    public String versionNumber;//v4.0.4——test&

    public String versionNo;//426&

    public String versionName;//v4.0.4——test

    public BaseReq() {
        this.optSystem = "android"+android.os.Build.VERSION.RELEASE;
        this.screen = DeviceUtils.getDisplayMetrics(AppUtils.getAppContext()).widthPixels
                +"*"
                +DeviceUtils.getDisplayMetrics(AppUtils.getAppContext()).heightPixels;

        this.terminalType ="1";
        this.terminalSn = DeviceUtils.getIMEI(AppUtils.getAppContext())
                + Settings.System.getString(AppUtils.getAppContext().getApplicationContext().getContentResolver(), Settings.System.ANDROID_ID);

        this.terminalFactory = Build.MANUFACTURER;
        this.terminalModel = Build.MODEL;
        this.versionNumber = DeviceUtils.getVersionName(AppUtils.getAppContext());
        this.versionNo = DeviceUtils.getVersionCode(AppUtils.getAppContext())+"";
        this.versionName =DeviceUtils.getVersionName(AppUtils.getAppContext());
    }

    @Override
    public String toString() {
        return "BaseReq{" +
                "optSystem='" + optSystem + '\'' +
                ", screen='" + screen + '\'' +
                ", terminalType='" + terminalType + '\'' +
                ", terminalSn='" + terminalSn + '\'' +
                ", terminalFactory='" + terminalFactory + '\'' +
                ", terminalModel='" + terminalModel + '\'' +
                ", versionNumber='" + versionNumber + '\'' +
                ", versionNo='" + versionNo + '\'' +
                ", versionName='" + versionName + '\'' +
                '}';
    }
}

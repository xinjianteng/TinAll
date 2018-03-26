package tin.geebook.utils;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 类名： TimeUtils
 * 描述：
 * 创建者: lhz
 * 创建时间: 16-8-19.
 * 版本：
 * 修改者：
 * 修改日期：
 */
public class TimeUtils {


    /***
     *获取当前时间
     * @param dateStyle  默认格式 eg:yyyyMMddHHmmss
     * @return
     */
    public static String getNowDate (String dateStyle) {
        String timeString;
        if(TextUtils.isEmpty(dateStyle)){
            timeString=new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
        }else {
            timeString=new SimpleDateFormat(dateStyle).format(Calendar.getInstance().getTime());
        }
        return timeString;
    }



}

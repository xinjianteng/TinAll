package tin.library.utils;


import android.util.Log;

import tin.library.config.AppConfig;

/**
 *  日记输出打印
 * @author T_xin
 * @date 2015-05-13
 * @version 1.0
 */
public class LogUtils {

	 	private LogUtils()
	    {
	        throw new UnsupportedOperationException("cannot be instantiated");
	    }

	    public static final String TAG = "LogUtils";


	    // 下面四个是默认tag的函数
	    public static void i(String msg)
	    {
	        if (AppConfig.isDebu)
	            Log.i(TAG,msg);
	    }

	    public static void d(String msg)
	    {
	        if (AppConfig.isDebu)
				Log.d(TAG,msg);
	    }

	    public static void e(String msg)
	    {
	        if (AppConfig.isDebu)
				Log.e(TAG,msg);
	    }

	    public static void v(String msg)
	    {
	        if (AppConfig.isDebu)
				Log.v( TAG,msg);
	    }

	    // 下面是传入自定义tag的函数
	    public static void i(String tag, String msg)
	    {
	        if (AppConfig.isDebu)
				Log.i(TAG,msg);
	    }

	    public static void d(String tag, String msg)
	    {
	        if (AppConfig.isDebu)
				Log.i( TAG,msg);
	    }

	    public static void e(String tag, String msg)
	    {
	        if (AppConfig.isDebu)
				Log.i( TAG,msg);
	    }

	    public static void v(String tag, String msg)
	    {
	        if (AppConfig.isDebu)
				Log.i(TAG,msg);
	    }


}

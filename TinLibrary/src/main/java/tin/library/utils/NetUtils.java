package tin.library.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 类名：NetUtils.java<br>
 * 描述： 网络状态工具类<br>
 * 创建者： XinJianTeng<br>
 * 创建日期：2016-06-21<br>
 * 版本： <br>
 * 修改者： <br>
 * 修改日期：<br>
 */
public class NetUtils {

	/**
	 * 判断当前是否连接网络
	 *
	 * @return
	 */
	public static boolean isConnected(Context context) {
		ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		return (networkInfo != null && networkInfo.isConnected());
	}

	/**
	 * 判断当前是否具有wifi连接
	 *
	 * @return
	 */
	public static boolean isWifiConnected(Context context) {
		ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		return (networkInfo != null && networkInfo.isConnected());
	}

	/**
	 * 判断当前是否具有移动数据网络连接
	 *
	 * @return
	 */
	public static boolean isMobileConnected(Context context) {
		ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		return (networkInfo != null && networkInfo.isConnected());
	}





}

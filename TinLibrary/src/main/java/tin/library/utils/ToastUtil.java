package tin.library.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import tin.library.R;


public class ToastUtil {
    /**
     * Toast弹出提示框工具类，用于简化Toast提示代码
     *
     * @author Tan Bo
     */

    private static Toast toast;

    //自定义toast布局，防止手机本身的字体更改
    private static View toastRoot;
    private static LinearLayout ll;
    private static TextView tv;

    /**
     * 默认方式显示Toast
     *
     * @param context 指定的Context实例
     * @param message 要设置通过过Toast显示的文本信息
     */
    public static void showToast(Activity baseActivity, Context context, String message) {
        if(!TextUtils.isEmpty(message)){
            if (context == null) {
                return;
            }
            if(toastRoot==null){
                toastRoot = baseActivity.getLayoutInflater().inflate(R.layout.view_toast, null);
                ll= (LinearLayout) toastRoot.findViewById(R.id.ll);
                tv = (TextView) toastRoot.findViewById(R.id.tv);
                toast= new Toast(context);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(toastRoot);
            }
            tv.setText(message);
            toast.show();
        }
    }

    /**
     * 默认方式显示Toast
     * @param context 指定的Context实例
     * @param message 要设置通过过Toast显示的文本信息
     */
    public static void show(Context context, String message) {
        if(!TextUtils.isEmpty(message)){
            if (context == null) {
                return;
            }
            if(toastRoot==null){
                toastRoot = LayoutInflater.from(context).inflate(R.layout.view_toast, null);
                ll= (LinearLayout) toastRoot.findViewById(R.id.ll);
                tv = (TextView) toastRoot.findViewById(R.id.tv);
                toast= new Toast(context);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(toastRoot);
            }
            tv.setText(message);
            toast.show();
        }
    }


    /**
     * 默认方式显示Toast
     *
     * @param context 指定的Context实例
     * @param resId 要设置通过过Toast显示的文本信息
     */
    public static void showToast(Activity baseActivity, Context context, int resId) {
        if (context == null) {
            return;
        }
        if(toastRoot==null){
            toastRoot = baseActivity.getLayoutInflater().inflate(R.layout.view_toast, null);
            ll= (LinearLayout) toastRoot.findViewById(R.id.ll);
            tv = (TextView) toastRoot.findViewById(R.id.tv);
            toast= new Toast(context);
            toast.setGravity(Gravity.CENTER, 0,0 );
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(toastRoot);
        }
        tv.setText(context.getResources().getString(resId));
        toast.show();
    }




}
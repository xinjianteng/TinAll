package tin.library.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;


/**
 * 类名：ActivityUtils.java<br>
 * 描述： Actiivty管理类<br>
 * 创建者： XinJianTeng<br>
 * 创建日期：2017-06-21<br>
 * 版本： <br>
 * 修改者： <br>
 * 修改日期：<br>
 */
public class ActivityUtils {

    public static Stack<Activity> activityStack;
    private static ActivityUtils instance;

    /**
     * 单一实例
     */
    public static ActivityUtils getAppManager() {
        if (instance == null) {
            instance = new ActivityUtils();
        }
        return instance;
    }

    /**
     * 添加Activity到堆栈
     */
    public static void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }


    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public static Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 回到某个页面
     *
     * @param cls
     */
    public static void goActivity(Class<?> cls) {
        try {
            List<Activity> activities = new ArrayList<Activity>();
            for (int i = activityStack.size() - 1; i > 0; i--) {
                Activity activity = activityStack.get(i);
                if (activity != null && !activity.getClass().equals(cls)) {
                    activities.add(activity);
                    activity.finish();
                    activity = null;
                } else {
                    break;
                }
            }
            for (int i = 0; i < activities.size(); i++) {
                activityStack.remove(activities.get(i));
            }
            activities.clear();
            activities = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void goActivity2(Class<?> cls) {
        try {
            List<Activity> activities = new ArrayList<Activity>();
            for (int i = activityStack.size() - 1; i > 0; i--) {
                Activity activity = activityStack.get(i);
                if (activity != null && !activity.getClass().equals(cls)) {
                    activities.add(activity);
                    activity.finish();
                    activity = null;
                } else {
                    break;
                }
            }
            for (int i = 0; i < activities.size(); i++) {
                activityStack.remove(activities.get(i));
            }
            activities.clear();
            activities = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭其他activity 只剩下一个
     *
     * @param only 不关闭的activity名称
     */
    public static void finishOtherActivity(Class<?> only) {
        try {
            List<Activity> activities = new ArrayList<Activity>();
            for (int i = 0; i < activityStack.size(); i++) {
                Activity activity = activityStack.get(i);
                if (activity != null && activity.getClass().equals(only)) {
                    break;
                } else {
                    activities.add(activity);
                    activity.finish();
                    activity = null;
                }
            }
            for (int i = 0; i < activities.size(); i++) {
                activityStack.remove(activities.get(i));
            }
            activities.clear();
            activities = null;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 结束指定的Activity
     */
    public static void finishActivity(Activity activity) {
        try {
            if (activity != null) {
                try {
                    activityStack.remove(activity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                activity.finish();
                activity = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 移除指定的Activity 并未进行finish操作
     */
    public static void removeActivity(Activity activity) {
        try {
            if (activity != null) {
                activityStack.remove(activity);
                activity = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 结束指定类名的Activity
     */
    public static void finishActivity(Class<?> cls) {
        try {
            for (Activity activity : activityStack) {
                if (activity.getClass().equals(cls)) {
                    finishActivity(activity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 结束所有Activity
     */
    public static void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }


    /**
     * 退出应用程序
     */
    public static void AppExit(Context context) {
        try {
            finishAllActivity();
            ActivityManager activityMgr = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.restartPackage(context.getPackageName());
            System.exit(0);
            android.os.Process.killProcess(android.os.Process.myPid());
        } catch (Exception e) {
        }
    }

    public static Stack<Activity> getActivityStack() {
        return activityStack;
    }

    public static void setActivityStack(Stack<Activity> activityStack) {
        ActivityUtils.activityStack = activityStack;
    }


    public static Activity findActivity(String name) {
        if (activityStack == null)
            return null;
        Iterator iter = activityStack.iterator();
        while (iter.hasNext()) {
            Activity abs = (Activity) iter.next();
            if (name.equals(abs.getClass().getName()))
                return abs;
        }
        return null;
    }



}
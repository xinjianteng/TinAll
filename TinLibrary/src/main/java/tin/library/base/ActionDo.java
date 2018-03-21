package tin.library.base;


import java.util.HashMap;

import tin.library.utils.LogUtils;


/**
 *
 * 类名： Action.java<br>
 * 描述： 基础Action <br>
 * 创建者： XinJianTeng<br>
 * 创建日期：2016-06-24<br>
 * 版本： <br>
 * 修改者： <br>
 * 修改日期：<br>
 */
public class ActionDo
{
    static final String TAG = "ActionDo";

    private static final HashMap<String, Action> mCodeToActionMap = new HashMap();

    private static ActionDo mApplication;

    public static ActionDo Instance()
    {
        return mApplication;
    }

    public ActionDo() {
        mApplication = this;
    }

    public final void addAction(String code, Action action)
    {
        mCodeToActionMap.put(code, action);
    }

    public final void removeAction(String code)
    {
        mCodeToActionMap.remove(code);
    }

    public final boolean isActionEnabled(String code)
    {
        Action action = mCodeToActionMap.get(code);
        return (action != null) && (action.isEnabled());
    }

    public void doAction(String code, Object[] p)
    {
        Action action = mCodeToActionMap.get(code);
        if (action != null)
            action.checkAndRun(p);
        else
            LogUtils.e(TAG, code + " action is null ... note by yangn");
    }

    public void doAction(String code)
    {
        Action action = mCodeToActionMap.get(code);
        if (action != null)
            action.checkAndRun(new Object[0]);
        else
            LogUtils.e(TAG, code + " action is null ... note by yangn");
    }

}
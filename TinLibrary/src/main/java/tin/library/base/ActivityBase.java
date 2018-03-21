package tin.library.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zhy.autolayout.AutoLayoutActivity;

import org.xutils.x;

import tin.library.utils.ActivityUtils;
/**
 * 类名：ActivityBase.java<br>
 * 描述： Actiivty管理类<br>
 * 创建者： XinJianTeng<br>
 * 创建日期：2017-06-21<br>
 * 版本： <br>
 * 修改者： <br>
 * 修改日期：<br>
 */
public  abstract  class ActivityBase extends AutoLayoutActivity {


    public abstract void initView();
    protected abstract void initAction();
    protected abstract void removeAction();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUtils.addActivity(this);
        x.view().inject(this);
        initView();
    }


    @Override
    public void finish() {
        super.finish();
        ActivityUtils.finishActivity(this);
    }


    public void addAction(String code, Action action) {
        ActionDo.Instance().addAction(code, action);
    }


    public void removeAction(String code) {
        ActionDo.Instance().removeAction(code);
    }

    public void doAction(String code, Object... p) {
        ActionDo.Instance().doAction(code, p);
    }




}

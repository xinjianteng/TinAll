package tin.library.base;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * Created by Administrator on 2018/3/9.
 */
public abstract class ApplicationBase extends android.app.Application {

    @Override
    public void onCreate() {
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
        new ActionDo();

        configData();
    }


    /***
     * 配置基础数据
     */
    protected abstract void configData();



}

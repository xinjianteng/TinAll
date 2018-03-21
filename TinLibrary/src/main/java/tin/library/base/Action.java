package tin.library.base;


/**
 *
 * 类名： Action.java<br>
 * 描述： 抽象类Action 用于让所有业务类Action集成、并重写方法<br>
 * 创建者： XinJianTeng<br>
 * 创建日期：2016-06-24<br>
 * 版本： <br>
 * 修改者： <br>
 * 修改日期：<br>
 */
public abstract class Action
{

    private boolean mEnable = true;

    public void setEnable(boolean isEnable)
    {
        this.mEnable = isEnable;
    }

    public boolean isEnabled()
    {
        return this.mEnable;
    }

    /***
     * 检查是否已经运行
     * @param o
     * @return
     */
    public final boolean checkAndRun(Object[] o)
    {
        if (isEnabled()) {
            run(o);
            return true;
        }
        return false;
    }

    /***
     * 启动运行
     * @param paramArrayOfObject
     */
    protected abstract void run(Object[] paramArrayOfObject);

}
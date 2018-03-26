package tin.geebook.ui.main;

/**
 * Created by Administrator on 2018/3/22.
 */

public class MainPresenter implements MainContract.IMainPresenter{


    private MainContract.IMainView mMainView;
    private MainContract.IMainModel mMainModel;

    public MainPresenter(MainContract.IMainView mMainView) {
        this.mMainView = mMainView;
        mMainModel=new MainModel();
    }

    /***
     * 点击藏书
     */
    @Override
    public void clickLibrary() {

    }

    /***
     * 点击借阅
     */
    @Override
    public void clickBorrow() {

    }

    /***
     * 点击发现
     */
    @Override
    public void clickFind() {

    }

    /***
     * 点击我的
     */
    @Override
    public void clickMe() {

    }

    /***
     * 查询本地书籍
     */
    @Override
    public void queryLocationBook() {

    }


}

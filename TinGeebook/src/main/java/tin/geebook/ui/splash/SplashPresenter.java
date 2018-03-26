package tin.geebook.ui.splash;

/**
 * Created by Administrator on 2018/3/23.
 */

public class SplashPresenter implements SplashContract.ISplashPresenter {

    private SplashContract.ISplashView iSplashView;
    private SplashContract.ISplashModel iSplashModel;

    public SplashPresenter(SplashContract.ISplashView iSplashView) {
        this.iSplashView = iSplashView;
        iSplashModel=new SplashModel();
    }

    /***
     * 查询闪屏图片
     */
    @Override
    public void querySplashImg() {
        iSplashModel.querySplashImg();

    }

}

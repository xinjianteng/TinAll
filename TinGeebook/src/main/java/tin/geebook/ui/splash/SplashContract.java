package tin.geebook.ui.splash;

/**
 * Created by Administrator on 2018/3/23.
 */

public class SplashContract {

    interface ISplashView {

    }

    interface ISplashPresenter{
        /***
         * 查询闪屏图片
         */
        void querySplashImg();

    }

    interface ISplashModel{

        /***
         * 查询闪屏图
         */
        void querySplashImg();

    }

}

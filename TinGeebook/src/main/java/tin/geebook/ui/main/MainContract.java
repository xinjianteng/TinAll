package tin.geebook.ui.main;

/**
 * Created by Administrator on 2018/3/22.
 */
public class MainContract {

    interface IMainView {
        /**
         * 显示藏书
         */
        void showLibrary();
        /***
         * 显示借阅
         */
        void showBorrow();

        /***
         * 显示发现
         */
        void showFind();

        /***
         * 显示我的
         */
        void showMe();

    }


    interface IMainPresenter {
        /***
         * 点击藏书
         */
        void clickLibrary();
        /***
         * 点击借阅
         */
        void clickBorrow();

        /***
         * 点击发现
         */
        void clickFind();

        /***
         * 点击我的
         */
        void clickMe();


        /***
         * 查询本地书籍
         */
        void queryLocationBook();


    }


    interface IMainModel{

    }

}

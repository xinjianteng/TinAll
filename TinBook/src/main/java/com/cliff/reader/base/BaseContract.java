package com.cliff.reader.base;

/**
 * Created by Administrator on 2017/12/25.
 */

/***
 * 项目名称： Tin看书
 * 类名：BaseContract
 * 类描述：基础控制器
 * 作者：xinjianteng
 * 创建时间：2018/2/9  14:03 
 * 版本号：1.0.0
 * 
*/
public interface BaseContract {


    /**
     * 基础
     * @param <T>
     */
    interface BasePresenter<T> {
        //付加视图
        void attachView(T view);

        //拆分视图
        void detachView();
    }



    interface BaseView {
        void showError();
        void complete();
    }

}

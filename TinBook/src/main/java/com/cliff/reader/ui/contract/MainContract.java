/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cliff.reader.ui.contract;


import com.cliff.reader.base.BaseContract;

/**
 * 首页控制器
 * @author Txin.
 * @date 2018/02/09.
 */
public interface MainContract {

    interface View extends BaseContract.BaseView {

        /***
         * 登陆成功
         */
        void loginSuccess();

        /***
         * 同步成功
         */
        void syncBookShelfCompleted();
    }



    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        /***
         * 第三方登陆
         * @param uid
         * @param token
         * @param platform
         */
        void login(String uid, String token, String platform);

        /***
         * 账号密码登陆
         * @param account
         * @param password
         */
        void login(String account, String password);

        /***
         * 同步书架
         */
        void syncBookShelf();
    }


}

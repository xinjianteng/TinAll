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
package com.cliff.reader.api;


import com.cliff.reader.base.Constant;
import com.cliff.reader.bean.AutoComplete;
import com.cliff.reader.bean.BookMixAToc;
import com.cliff.reader.bean.ChapterRead;
import com.cliff.reader.bean.HotWord;
import com.cliff.reader.bean.Recommend;
import com.cliff.reader.bean.SearchDetail;
import com.cliff.reader.bean.base.BaseReq;
import com.cliff.reader.bean.user.Login;
import com.cliff.reader.bean.user.LoginReq;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;
import rx.Observable;

/**
 * https://github.com/JustWayward/BookReader
 *
 * @author yuyh.
 * @date 2016/8/3.
 */
public class BookApi {

    public static BookApi instance;

    private BookApiService service;

    private BaseReq baseReq;

    public BookApi(OkHttpClient okHttpClient) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.API_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create())//使用工厂模式创建Gason的解析器,添加Gson转换器
                .client(okHttpClient)
                .build();

        baseReq=new BaseReq();
        service = retrofit.create(BookApiService.class);
    }



    public static BookApi getInstance(OkHttpClient okHttpClient) {
        if (instance == null)
            instance = new BookApi(okHttpClient);
        return instance;
    }

    public Observable<Login> login(String platform_uid, String platform_token, String platform_code) {
        LoginReq loginReq = new LoginReq();
        loginReq.platform_code = platform_code;
        loginReq.platform_token = platform_token;
        loginReq.platform_uid = platform_uid;
        return service.login(loginReq);
    }



    public Observable<Login> login(String username,String password) {
//        return service.login(username,password);
        return service.login(username,password,
                baseReq.optSystem,baseReq.screen,baseReq.terminalType,baseReq.terminalSn,baseReq.terminalFactory,baseReq.terminalModel,baseReq.versionNumber,baseReq.versionNo,baseReq.versionName);
    }


    public synchronized Observable<ChapterRead> getChapterRead(String url) {
        return service.getChapterRead(url);
    }

    public Observable<BookMixAToc> getBookMixAToc(String bookId, String view) {
        return service.getBookMixAToc(bookId, view);
    }


    public Observable<Recommend> getRecommend(String gender) {
        return service.getRecomend(gender);
    }


    /***
     * 热门搜索词
     * @return
     */
    public Observable<HotWord> getHotWord(int nowPage,int onePageCount) {
        return service.getHotWord(nowPage,onePageCount);
    }

    /**
     * 搜索关键字自动补全
     * @param query
     * @return
     */
    public Observable<AutoComplete> getAutoComplete(String query) {
        return service.autoComplete(query);
    }


    public Observable<SearchDetail> getSearchResult(String query) {
        return service.searchBooks(query);
    }


}

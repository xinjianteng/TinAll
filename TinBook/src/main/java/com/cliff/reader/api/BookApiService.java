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

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * https://github.com/JustWayward/BookReader
 *
 * @author yuyh.
 * @date 2016/8/3.
 */
public interface BookApiService {

    /**
     *  第三方登陆
     * @param loginReq
     * @return
     */
    @POST("/cLogin.go")
    Observable<Login> login(@Body LoginReq loginReq);

    /**
     * 账号登陆
     * @param username
     * @param password
     * @return
     */
    @POST("/librarys/cLogin.go")
    Observable<Login> login(@Query("username") String username, @Query("password") String password
            , @Query("optSystem") String optSystem
            , @Query("screen") String screen
            , @Query("terminalType") String terminalType
            , @Query("terminalSn") String terminalSn
            , @Query("terminalFactory") String terminalFactory
            , @Query("terminalModel") String terminalModel
            , @Query("versionNumber") String versionNumber
            , @Query("versionNo") String versionNo
            , @Query("versionName") String versionName);



    @GET("http://chapter2.zhuishushenqi.com/chapter/{url}")
    Observable<ChapterRead> getChapterRead(@Path("url") String url);


    @GET("/mix-atoc/{bookId}")
    Observable<BookMixAToc> getBookMixAToc(@Path("bookId") String bookId, @Query("view") String view);


    @GET("/book/recommend")
    Observable<Recommend> getRecomend(@Query("gender") String gender);



    @GET("/library/cGetHotSearchListAction.go")
    Observable<HotWord> getHotWord(@Query("nowPage") int nowPage,@Query("onePageCount") int onePageCount);

    /**
     * 搜索关键字自动补全
     *
     * @param query
     * @return
     */
    @GET("/book/auto-complete")
    Observable<AutoComplete> autoComplete(@Query("query") String query);


    /**
     * 书籍查询
     *
     * @param query
     * @return
     */
    @GET("/book/fuzzy-search")
    Observable<SearchDetail> searchBooks(@Query("query") String query);



}
/*
 * Copyright 2016 ikidou
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * [Retrofit入门]源码
 */
public class Example01 {

    public interface BlogService {
        @GET("blog/{id}") //这里的{id} 表示是一个变量
        Call<ResponseBody> getBlog(/** 这里的id表示的是上面的{id} */@Path("id") int id);

        @POST("screen/cGetCommGlintList.go")
        Call<ResponseBody> getSplash();
    }

//    http://202.109.245.174:9988/screen/cGetCommGlintList.go

    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://202.109.245.174:9988/")
                .build();

        BlogService service = retrofit.create(BlogService.class);

        Call<ResponseBody> call=service.getSplash();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }


}

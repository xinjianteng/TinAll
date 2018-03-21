/**
 * Copyright 2016 JustWayward Team
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cliff.reader.manager.cache;

import android.content.Context;
import android.text.TextUtils;

import com.cliff.reader.ReaderApplication;
import com.cliff.reader.base.Constant;
import com.cliff.reader.bean.BookLists;
import com.cliff.reader.bean.BookMixAToc;
import com.cliff.reader.bean.ChapterRead;
import com.cliff.reader.manager.CollectionsManager;
import com.cliff.reader.manager.SettingManager;
import com.cliff.reader.utils.ACache;
import com.cliff.reader.utils.AppUtils;
import com.cliff.reader.utils.FileUtils;
import com.cliff.reader.utils.LogUtils;
import com.cliff.reader.utils.SharedPreferencesUtil;
import com.cliff.reader.utils.StringUtils;
import com.cliff.reader.utils.ToastUtils;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 搜索记录缓存管理器
 * @author yuyh.
 * @date 2016/9/28.
 */
public class SearchHistoryCacheManager {

    private static SearchHistoryCacheManager manager;

    public static SearchHistoryCacheManager getInstance() {
        return manager == null ? (manager = new SearchHistoryCacheManager()) : manager;
    }

    /**
     * 获取搜索历史列表list
     * @return
     */
    public List<String> getSearchHistory() {
        return SharedPreferencesUtil.getInstance().getObject(getSearchHistoryKey(), List.class);
    }

    /**
     * 保存搜索历史
     * @param obj
     */
    public void saveSearchHistory(Object obj) {
        SharedPreferencesUtil.getInstance().putObject(getSearchHistoryKey(), obj);
    }


    /***
     * 缓存-搜索关键字
     * @return
     */
    private String getSearchHistoryKey() {
        return "searchHistory";
    }

}

package com.cliff.reader.manager.setting;

import com.cliff.reader.bean.support.BookMark;
import com.cliff.reader.utils.AppUtils;
import com.cliff.reader.utils.ScreenUtils;
import com.cliff.reader.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 阅读器亮度设置管理
 * @author Tin.
 * @date 2017/12/27.
 */
public class BookMarksManager {

    private volatile static BookMarksManager bookMarksManager;

    public static BookMarksManager getInstance() {
        return bookMarksManager != null ? bookMarksManager : (bookMarksManager = new BookMarksManager());
    }

    public boolean addBookMark(String bookId, BookMark mark) {
        List<BookMark> marks = SharedPreferencesUtil.getInstance().getObject(getBookMarksKey(bookId), ArrayList.class);
        if (marks != null && marks.size() > 0) {
            for (BookMark item : marks) {
                if (item.chapter == mark.chapter && item.startPos == mark.startPos) {
                    return false;
                }
            }
        } else {
            marks = new ArrayList<>();
        }
        marks.add(mark);
        SharedPreferencesUtil.getInstance().putObject(getBookMarksKey(bookId), marks);
        return true;
    }

    public List<BookMark> getBookMarks(String bookId) {
        return SharedPreferencesUtil.getInstance().getObject(getBookMarksKey(bookId), ArrayList.class);
    }

    public void clearBookMarks(String bookId) {
        SharedPreferencesUtil.getInstance().remove(getBookMarksKey(bookId));
    }

    private String getBookMarksKey(String bookId) {
        return bookId + "-marks";
    }

}

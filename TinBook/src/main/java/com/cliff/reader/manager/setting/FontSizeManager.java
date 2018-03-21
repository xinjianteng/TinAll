package com.cliff.reader.manager.setting;

import com.cliff.reader.manager.SettingManager;
import com.cliff.reader.utils.ScreenUtils;
import com.cliff.reader.utils.SharedPreferencesUtil;

/**
 *
 * 阅读器字体设置管理
 * @author Tin.
 * @date 2017/12/27.
 */
public class FontSizeManager {

    private volatile static FontSizeManager fontSizeManager;

    public static FontSizeManager getInstance() {
        return fontSizeManager != null ? fontSizeManager : (fontSizeManager = new FontSizeManager());
    }

    private String getFontSizeKey(String bookId) {
        return bookId + "-readFontSize";
    }

    /**
     * 保存书籍阅读字体大小
     *
     * @param bookId     需根据bookId对应，避免由于字体大小引起的分页不准确
     * @param fontSizePx
     * @return
     */
    public void saveFontSize(String bookId, int fontSizePx) {
        // 书籍对应
        SharedPreferencesUtil.getInstance().putInt(getFontSizeKey(bookId), fontSizePx);
    }

    /**
     * 保存全局生效的阅读字体大小
     *
     * @param fontSizePx
     */
    public void saveFontSize(int fontSizePx) {
        saveFontSize("", fontSizePx);
    }


    /***
     * 获取书籍阅读的字体大小
     * @param bookId
     * @return
     */
    public int getReadFontSize(String bookId) {
        return SharedPreferencesUtil.getInstance().getInt(getFontSizeKey(bookId), ScreenUtils.dpToPxInt(16));
    }

    /***
     * 获取全局书籍阅读的字体大小
     * @return
     */
    public int getReadFontSize() {
        return getReadFontSize("");
    }


}

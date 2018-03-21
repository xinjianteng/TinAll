package tin.browser.base;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;

import com.scwang.smartrefresh.layout.api.RefreshLayout;

import tin.library.base.ActivityBase;

/**
 * Created by Administrator on 2018/3/12.
 */

public class ActivityBrowserBase extends tin.library.base.ActivityBase {

    public Toolbar mToolbar;
    private RefreshLayout mRefreshLayout;

    @Override
    public void initView() {

    }

    @Override
    protected void initAction() {

    }

    @Override
    protected void removeAction() {

    }


    private void setThemeColor(int colorPrimary, int colorPrimaryDark) {
        mToolbar.setBackgroundResource(colorPrimary);
        mRefreshLayout.setPrimaryColorsId(colorPrimary, android.R.color.white);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, colorPrimaryDark));
        }
    }


}

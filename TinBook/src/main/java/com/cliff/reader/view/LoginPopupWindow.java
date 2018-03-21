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
package com.cliff.reader.view;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.cliff.reader.R;
import com.cliff.reader.utils.StringUtils;
import com.cliff.reader.utils.ToastUtils;


/**
 * 登陆弹出框
 * @author yuyh.
 * @date 16/9/5.
 */
public class LoginPopupWindow extends PopupWindow implements View.OnTouchListener {

    private View mContentView;
    private Activity mActivity;

    private EditText account;
    private EditText password;
    private Button btnLogin;

    private ImageView qq;
    private ImageView sina;
    private ImageView wechat;

    LoginTypeListener listener;

    public enum LoginType{
        LoginForQQ,
        LoginForSina,
        LoginForWechat,
        LoginForAccount
    }


    public LoginPopupWindow(Activity activity) {
        mActivity = activity;
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        mContentView = LayoutInflater.from(activity).inflate(R.layout.layout_login_popup_window, null);
        setContentView(mContentView);

        account= (EditText) mContentView.findViewById(R.id.account);
        password= (EditText) mContentView.findViewById(R.id.password);
        btnLogin= (Button) mContentView.findViewById(R.id.btnLogin);

        qq = (ImageView) mContentView.findViewById(R.id.ivQQ);
        sina = (ImageView) mContentView.findViewById(R.id.ivSina);
        wechat = (ImageView) mContentView.findViewById(R.id.ivWechat);

        qq.setOnTouchListener(this);
        sina.setOnTouchListener(this);
        wechat.setOnTouchListener(this);
        btnLogin.setOnTouchListener(this);

        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));

        setAnimationStyle(R.style.LoginPopup);

        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                lighton();
            }
        });

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                scale(v, true);
                break;
            case MotionEvent.ACTION_UP:
                scale(v, false);
                break;
        }
        return false;
    }


    private void scale(View v, boolean isDown) {
        if (v.getId() == qq.getId() || v.getId() == sina.getId() || v.getId() == wechat.getId()) {
            if (isDown) {
                Animation testAnim = AnimationUtils.loadAnimation(mActivity, R.anim.scale_down);
                v.startAnimation(testAnim);
            } else {
                Animation testAnim = AnimationUtils.loadAnimation(mActivity, R.anim.scale_up);
                v.startAnimation(testAnim);
            }
        }
        if (!isDown && listener!=null) {
            switch (v.getId()) {
                case R.id.ivQQ:
                    listener.onLogin(LoginType.LoginForQQ);
                    qq.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dismiss();
                        }
                    }, 500);
                    break;
                case R.id.ivSina://
                    listener.onLogin(LoginType.LoginForSina);
                    break;
                case R.id.ivWechat://
                    listener.onLogin(LoginType.LoginForWechat);
                    break;
                case R.id.btnLogin://
                    if(TextUtils.isEmpty(account.getText())||TextUtils.isEmpty(password.getText().toString())){
                        ToastUtils.showLongToast("账号/密码 不能为空");
                    }else {
                        listener.onLogin(LoginType.LoginForAccount, account.getText().toString(),password.getText().toString());
                    }
                    break;
            }
        }
    }

    private void lighton() {
        WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
        lp.alpha = 1.0f;
        mActivity.getWindow().setAttributes(lp);
    }

    private void lightoff() {
        WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
        lp.alpha = 0.3f;
        mActivity.getWindow().setAttributes(lp);
    }

    @Override
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        lightoff();
        super.showAsDropDown(anchor, xoff, yoff);
    }

    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        lightoff();
        super.showAtLocation(parent, gravity, x, y);
    }


    public interface LoginTypeListener {

        void onLogin(LoginType loginType,String... strings);

    }

    public void setLoginTypeListener(LoginTypeListener listener){
        this.listener = listener;
    }

}

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
package com.cliff.reader.bean.user;


import com.cliff.reader.bean.base.Base;

/**
 * @author yuyh.
 * @date 16/9/4.
 */
public class Login extends Base {


    /**
     * _id : 57cbf0278b37eb5f05496f8b
     * nickname : ✘。
     * avatar : /avatar/eb/a0/eba095c72cc992bdea6539ce1cfd0aff
     * exp : 0
     * lv : 1
     * gender : female
     * type : normal
     */

    public UserBean user;
    /**
     * user : {"_id":"57cbf0278b37eb5f05496f8b","nickname":"✘。","avatar":"/avatar/eb/a0/eba095c72cc992bdea6539ce1cfd0aff","exp":0,"lv":1,"gender":"female","type":"normal"}
     * token : gmPcsbwQ41UfTQEc7yMnBiRY
     */

    public String token;

    public static class UserBean {
        private Long id;
        private Integer visible;
        private Integer lastSyncTime;
        private int accountId = 0;
        //    private String appPic;//未知参数
        private int attNum;//:4, 我关注的人数
        private int attbyNum;//:4, 关注我的人数
        private String email;//邮箱
        private int auditStatus;//:2, 未知参数
        private int friendNum;//:2, 书友数
        private Integer geebooNo;
        private int gender;//性别 0未知，1男2女
        private Integer isComplete;//用户信息是否完善0否1是
        private Integer isEmail;//eg: 0
        private Integer isPassword;//eg:1
        private String lastLoginip;//,最后登录ip
        private long lastLoginTime;//最后登录时间
        private String nickname;//姓名
        private String password;//密码
        //    private String path;
        private String phone;//手机号
        private String photo;//头像
        private long regTime;//注册时间
        private Integer regType;//注册类型(1邮箱，2手机，3第三方，4批量 ,5手机)
        private int sayNum;//未知参数1
        private String signature;// 个性签名
        private String softVersion;//软件版本号308
        private String sorts;
        private Integer thirdType;
        private String mobile;
        private String token;
        private String app;

        @Override
        public String toString() {
            return "UserBean{" +
                    "id=" + id +
                    ", visible=" + visible +
                    ", lastSyncTime=" + lastSyncTime +
                    ", accountId=" + accountId +
                    ", attNum=" + attNum +
                    ", attbyNum=" + attbyNum +
                    ", email='" + email + '\'' +
                    ", auditStatus=" + auditStatus +
                    ", friendNum=" + friendNum +
                    ", geebooNo=" + geebooNo +
                    ", gender=" + gender +
                    ", isComplete=" + isComplete +
                    ", isEmail=" + isEmail +
                    ", isPassword=" + isPassword +
                    ", lastLoginip='" + lastLoginip + '\'' +
                    ", lastLoginTime=" + lastLoginTime +
                    ", nickname='" + nickname + '\'' +
                    ", password='" + password + '\'' +
                    ", phone='" + phone + '\'' +
                    ", photo='" + photo + '\'' +
                    ", regTime=" + regTime +
                    ", regType=" + regType +
                    ", sayNum=" + sayNum +
                    ", signature='" + signature + '\'' +
                    ", softVersion='" + softVersion + '\'' +
                    ", sorts='" + sorts + '\'' +
                    ", thirdType=" + thirdType +
                    ", mobile='" + mobile + '\'' +
                    ", token='" + token + '\'' +
                    ", app='" + app + '\'' +
                    '}';
        }
    }


}

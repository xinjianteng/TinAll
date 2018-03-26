package tin.geebook.bean;


import android.text.TextUtils;

import java.io.Serializable;


/**
 * 类名：UserBean.java<br>
 * 描述： 用户信息<br>
 * 创建者： XinJianTeng<br>
 * 创建日期：2016-08-01<br>
 * 版本： <br>
 * 修改者： <br>
 * 修改日期：<br>
 */

public class UserBean {
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
    private String loginPassword="";//密码
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

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
                ", loginPassword='" + loginPassword + '\'' +
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
                ", loginStyle=" + loginStyle +
                ", dynamicNum=" + dynamicNum +
                ", isBinding=" + isBinding +
                '}';
    }

    public UserBean() {
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public Integer getLastSyncTime() {
        return lastSyncTime;
    }

    public void setLastSyncTime(Integer lastSyncTime) {
        this.lastSyncTime = lastSyncTime;
    }

    public String getApp() {
        return app;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public void setApp(String app) {
        this.app = app;
    }

    private int loginStyle;  //* 1: 手机登陆* 2：第三方登陆  * 3：邮箱登陆

    public int getLoginStyle() {
        return loginStyle;
    }

    public void setLoginStyle(int loginStyle) {
        this.loginStyle = loginStyle;
    }

    public UserBean(int accountId) {
        this.accountId = accountId;
    }

    private int dynamicNum=0;

    private boolean isBinding=false;//是否绑定手机号

    public boolean isBinding() {
        return isBinding;
    }

    public void setBinding(boolean binding) {
        isBinding = binding;
    }

    public int getDynamicNum() {
        return dynamicNum;
    }

    public void setDynamicNum(int dynamicNum) {
        this.dynamicNum = dynamicNum;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAttNum() {
        return attNum;
    }

    public void setAttNum(int attNum) {
        this.attNum = attNum;
    }

    public int getAttbyNum() {
        return attbyNum;
    }

    public void setAttbyNum(int attbyNum) {
        this.attbyNum = attbyNum;
    }

    public String getEmail() {
        if(TextUtils.isEmpty(email)){
            return "";
        }
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(int auditStatus) {
        this.auditStatus = auditStatus;
    }

    public int getFriendNum() {
        return friendNum;
    }

    public void setFriendNum(int friendNum) {
        this.friendNum = friendNum;
    }

    public Integer getGeebooNo() {
        return geebooNo;
    }

    public void setGeebooNo(Integer geebooNo) {
        this.geebooNo = geebooNo;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Integer getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Integer isComplete) {
        this.isComplete = isComplete;
    }

    public Integer getIsEmail() {
        return isEmail;
    }

    public void setIsEmail(Integer isEmail) {
        this.isEmail = isEmail;
    }

    public Integer getIsPassword() {
        return isPassword;
    }

    public void setIsPassword(Integer isPassword) {
        this.isPassword = isPassword;
    }

    public String getLastLoginip() {
        return lastLoginip;
    }

    public void setLastLoginip(String lastLoginip) {
        this.lastLoginip = lastLoginip;
    }

    public long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        if(TextUtils.isEmpty(password)){
            return "";
        }
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getRegTime() {
        return regTime;
    }

    public void setRegTime(long regTime) {
        this.regTime = regTime;
    }

    public Integer getRegType() {
        return regType;
    }

    public void setRegType(Integer regType) {
        this.regType = regType;
    }

    public int getSayNum() {
        return sayNum;
    }

    public void setSayNum(int sayNum) {
        this.sayNum = sayNum;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSoftVersion() {
        return softVersion;
    }

    public void setSoftVersion(String softVersion) {
        this.softVersion = softVersion;
    }

    public String getSorts() {
        if(TextUtils.isEmpty(sorts)){
            return "";
        }else {
            return sorts;
        }
    }

    public void setSorts(String sorts) {
        this.sorts = sorts;
    }

    public Integer getThirdType() {
        return thirdType;
    }

    public void setThirdType(Integer thirdType) {
        this.thirdType = thirdType;
    }


    public boolean isMySelf(int id){
        return accountId == id;
    }
}

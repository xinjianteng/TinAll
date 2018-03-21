package com.cliff.reader.bean.base;


/**
 *
 * 类名： PageMsg.java<br>
 * 描述： 分页数据信息 <br>
 * 创建者： XinJianTeng<br>
 * 创建日期：2016-06-24<br>
 * 版本： <br>
 * 修改者： <br>
 * 修改日期：<br>
 */

public class ReturnMsg extends Base{

    public int flag;
    public double message;
    public Object messageName="";
    public Object data;

    /** -----后台接口返回不规范的参数   ---------**/
    public int libId; //档案创建请求  RequestUrl.MY_ARCHIVES_BUILD
    public String path;//阅读完结统计请求接口   分享点击 跳转链接的数据

    @Override
    public String toString() {
        return "ReturnMsg{" +
                "flag=" + flag +
                ", message=" + message +
                ", messageName='" + messageName + '\'' +
                ", data=" + data +
                '}';
    }


}

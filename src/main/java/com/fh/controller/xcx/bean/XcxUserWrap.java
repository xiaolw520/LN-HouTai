package com.fh.controller.xcx.bean;

import java.io.Serializable;

/**
 * 小程序用户 wrap
 */
public class XcxUserWrap implements Serializable{

    //errMsg
    private String errMsg;
    //rawData
    private String rawData;
    //userInfo
    private XcxUser userInfo;
    //encryptedData
    private String encryptedData;
    //iv
    private String iv;
    //signature
    private String signature;

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public XcxUser getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(XcxUser userInfo) {
        this.userInfo = userInfo;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}

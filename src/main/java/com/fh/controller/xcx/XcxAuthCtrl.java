package com.fh.controller.xcx;


import com.alibaba.fastjson.JSONObject;
import com.fh.controller.xcx.bean.XcxUser;
import com.fh.controller.xcx.bean.XcxUserWrap;
import com.fh.controller.xcx.utils.XcxCommonUtil;
import com.fh.util.*;
import com.ln.entity.Account;
import com.ln.entity.Code;
import com.ln.service.account.AccountManager;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 小程序认证登录
 */
@Controller
@RequestMapping("/xcx/auth")
public class XcxAuthCtrl {

    private static Logger logger = Logger.getLogger(XcxAuthCtrl.class);

    @Resource(name="accountService")
    private AccountManager accountService;

    /**
     * 授权登录
     * @param code
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestParam(name = "code") String code,
                      @RequestParam(name = "userJsonStr") String userJsonStr,
                      HttpServletRequest request , HttpServletResponse response) {
        String requestUrl = String.format(PropertiesUtil.getResourceString("wxxcx","wx.webAccessTokenhttps"),
                PropertiesUtil.getResourceString("wxxcx","wx.appId"),
                PropertiesUtil.getResourceString("wxxcx","wx.secret"),code);
        logger.info("--> requestUrl="+requestUrl);

        //获取openid
        JSONObject sessionData = XcxCommonUtil.doGet(requestUrl);
        if (null == sessionData || StringUtils.isEmpty(sessionData.getString("openid"))) {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("code", Code.XCXFail);
            return AppUtil.returnObject(new PageData() , map);
        }
        logger.info("--> openid="+sessionData.getString("openid"));

        XcxUserWrap xcxUserWrap = JSONObject.parseObject(userJsonStr, XcxUserWrap.class);

         //验证用户信息完整性
        String rawData = xcxUserWrap.getRawData();
        String signature = xcxUserWrap.getSignature();
        XcxUser xcxUser = xcxUserWrap.getUserInfo();
        if (StringUtils.isEmpty(rawData) || StringUtils.isEmpty(signature) || xcxUser == null) {
            logger.info("--> xcxUserWrap 参数为空");
            //WebUtils.doAction(Code.InvalidSign, request, response);
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("code", Code.XCXFail);
            return AppUtil.returnObject(new PageData() , map);
        }
        String signature2 = XcxCommonUtil.getSha1(rawData + sessionData.getString("session_key"));
        if (!signature.equals(signature2)) {
            logger.info("--> 签名校验失败");
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("code", Code.XCXFail);
            return AppUtil.returnObject(new PageData() , map);
        }
        String token = UUID.randomUUID().toString().replace("-", "");
        // 保存或查询用户
        Account accountModel = null;
        PageData pd = new PageData();
        pd.put("open_id",sessionData.get("openid"));
        try{
            accountModel = accountService.getAccountByTokenOrOpenid(pd);
            if (accountModel == null) {

                accountModel.setAccountid(UuidUtil.get32UUID());
                accountModel.setRefid(null);
                accountModel.setReftype((byte) 1);
                accountModel.setNick_name(xcxUser.getNickName());
                accountModel.setCity(xcxUser.getCity());
                accountModel.setProvince(xcxUser.getProvince());
                accountModel.setGender(xcxUser.getGender());
                accountModel.setIsdel(false);
                accountModel.setState((byte)0);
                accountModel.setCrtime(new Date());
                accountModel.setUptime(accountModel.getCrtime());
                accountModel.setOpen_id(sessionData.getString("openid"));
                accountModel.setUnion_id(null);
                // encryptedData 解密后为以下 json 结构，详见加密数据解密算法(AESUtil,WXBizDataCrypt) 可以获取到unionId
                JSONObject jsonObject = XcxCommonUtil.decryptData(PropertiesUtil.getResourceString("wxxcx","wx.appId"), sessionData.getString("session_key"),
                        xcxUserWrap.getEncryptedData(), xcxUserWrap.getIv());
                if (jsonObject != null) {
                    accountModel.setCountry(jsonObject.getString("country"));
                    accountModel.setUnion_id(jsonObject.getString("unionId"));
                }
                String avatarUrl = xcxUser.getAvatarUrl();
                accountModel.setAvatar_url(avatarUrl);

                accountModel.setToken(token);  // 更新登录凭证
                accountService.saveAccount(accountModel);
                //logger.info("--> 保存新用户成功 userModel="+userModel.getId());
            } else {
                accountModel.setToken(token);
                pd = new PageData();
                pd.put("uptime", Tools.date2Str(new Date()));
                pd.put("token", token);
                accountService.editToken(pd);  // 更新登录凭证*/
            }

        } catch (Exception e) {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("code", Code.XCXFail);
            return AppUtil.returnObject(new PageData() , map);
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", Code.Success);
        map.put("user",accountModel);
        return AppUtil.returnObject(new PageData() , map);
    }
}

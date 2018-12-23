package com.fh.controller.xcx.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URL;
import java.security.MessageDigest;

/**
 * 小程序工具包
 */
public class XcxCommonUtil {


    private static Logger log = LoggerFactory.getLogger(XcxCommonUtil.class);

    /**
     * 发送https请求
     *
     * @param requestUrl    请求地址
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject doGet(String requestUrl){
        HttpClient httpClient = null;
        HttpGet httpGet = null;
        JSONObject jsonObject = null;
        try{
            httpClient = new SSLClient();
            URL url = new URL(requestUrl);
            URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
            httpGet = new HttpGet(uri);
            HttpResponse response = httpClient.execute(httpGet);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    String result = EntityUtils.toString(resEntity,"utf-8");
                    jsonObject = JSONObject.parseObject(result);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return jsonObject;
    }

    public static String getSha1(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  解密 encryptedData
     * @return
     */
    public static JSONObject decryptData(String appId,String sessionKey, String encryptedData, String iv) {
        JSONObject obj = null;
        try {
            WXBizDataCrypt biz = new WXBizDataCrypt(appId, sessionKey);
            obj = JSONObject.parseObject(biz.decryptData(encryptedData, iv));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /*public static void main(String[] args) {
        JSONObject jsonObject = XcxCommonUtil.doGet("https://api.weixin.qq.com/sns/jscode2session?appid=wx9efc95b6bd4932b0&secret=aeb67b888d7a721123a628c96e52b4f3&js_code=033jk6Gs0u7qpd105TGs0VxaGs0jk6Gc&grant_type=authorization_code");
        System.out.println(jsonObject);
    }*/
}

package com.flare.utils;

import com.alibaba.fastjson.JSON;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Service
public class HttpUtils {
    @Resource(name = "httpClientManagerFactory")
    private CloseableHttpClient client;
    private Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    /**
     *
     * @param url 请求URL地址，不带?后面的
     * @param param 请求参数,如果没有，则传null
     * @return
     */
    public String doGet(String url ,Map<String,Object> param){
        HttpGet httpGet = null;
        if (param != null){
            httpGet = new HttpGet(url+ StringHelper.urlParamter("?",param));
        }else {
            httpGet = new HttpGet(url);
        }
        CloseableHttpResponse response = null;
        String responseMessage = null;
        HttpEntity httpEntity = null;
        try {
            response = client.execute(httpGet);
            httpEntity = response.getEntity();
            responseMessage = EntityUtils.toString(httpEntity, Consts.UTF_8);
            return responseMessage;
            }catch (IOException e) {
            logger.error("http get 请求出现异常"+e.getMessage());
            return "false";
        }finally {
            EntityUtils.consumeQuietly(httpEntity);
        }
    }

    public String doPost(String url,Map<String,Object> param) {
        CloseableHttpResponse response = null;
        String responseMessage = null;
        HttpEntity httpEntity = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            configHeard(httpPost);
            httpEntity = new StringEntity(JSON.toJSONString(param), "UTF-8");
            httpPost.setEntity(httpEntity);
            response = client.execute(httpPost);
            httpEntity = response.getEntity();
            responseMessage = EntityUtils.toString(httpEntity, Consts.UTF_8);
            logger.info("post 请求返回："+responseMessage +new Date());
            return responseMessage;
        }catch (IOException e) {
            logger.info("post 出现异常"+ e.getMessage());
            return "false";
        }finally {
            EntityUtils.consumeQuietly(httpEntity);// 释放连接
        }
    }

    private void configHeard(HttpPost httpPost) {
        httpPost.addHeader("Authorization", "yiwei");
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("User-Agent", "imgfornote");
    }
}

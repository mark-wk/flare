package com.flare.web.config.http;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class ArtPoolingHttpClientConnectionManager {

//    连接池最大连接数
    private int connMaxTotal = 20;

    private int maxPerRoute = 20;

//  连接存活时间，单位为s
    private int timeToLive = 60;

    @Bean
    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager(){
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(this.timeToLive, TimeUnit.SECONDS);
        poolingHttpClientConnectionManager.setMaxTotal(this.connMaxTotal);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(this.maxPerRoute);
        return poolingHttpClientConnectionManager;
    }
}

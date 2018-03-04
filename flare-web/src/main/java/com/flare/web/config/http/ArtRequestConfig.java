package com.flare.web.config.http;

import org.apache.http.client.config.RequestConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArtRequestConfig {

    private int connectTimeout = 2000;

    private int connectRequestTimeout = 2000;

    private int socketTimeout = 2000;
    @Bean
    public RequestConfig requestConfig(){
        return RequestConfig.custom()
                .setConnectTimeout(this.connectTimeout)
                .setConnectionRequestTimeout(this.connectRequestTimeout)
                .setSocketTimeout(this.socketTimeout)
                .build();
    }
}

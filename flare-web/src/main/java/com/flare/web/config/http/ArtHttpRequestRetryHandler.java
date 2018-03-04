package com.flare.web.config.http;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.protocol.HttpContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

@Configuration
public class ArtHttpRequestRetryHandler {
    private int retryTime = 10;
    @Bean
    public HttpRequestRetryHandler httpRequestRetryHandler(){
        //请求重试

        return new HttpRequestRetryHandler() {
            @Override
            public boolean retryRequest(IOException exception, int executionCount, HttpContext httpContext) {
                // Do not retry if over max retry count,如果重试次数超过了retryTime,则不再重试请求
                if (executionCount >= retryTime) {
                    return false;
                }
                // 服务端断掉客户端的连接异常
                if (exception instanceof NoHttpResponseException){
                    return true;
                }
                // time out 超时重试
                if (exception instanceof InterruptedIOException){
                    return true;
                }
                // Unknown host
                if (exception instanceof UnknownHostException){
                    return false;
                }
                // Connection refused
                if (exception instanceof ConnectTimeoutException){
                    return false;
                }
                // SSL handshake exception
                if (exception instanceof SSLException){
                    return false;
                }
                HttpClientContext clientContext = HttpClientContext.adapt(httpContext);
                HttpRequest request = clientContext.getRequest();
                if (!(request instanceof HttpEntityEnclosingRequest)){
                    return true;
                }
                return false;
            }
        };
    }
}

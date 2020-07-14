package com.Kotori.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 网关向api服务请求是失败了，但是消费者客户端向网关发起的请求是OK的，
 * 不应该把api的404,500等问题抛给客户端
 * 网关和api服务集群对于客户端来说是黑盒子
 * zuul提供的回退只能支持 宕机降级和超时降级
 * **/
@Component
public class ZuulFallback implements FallbackProvider {
    /***
     * 返回 * 表示为所有微服务实行降级
     * @return
     */
    @Override
    public String getRoute() {
        return "order-microservice-group";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            // 当微服务出现宕机后，客户端再请求时候就会返回 fallback 等字样的字符串提示
            // 但对于复杂一点的微服务，我们这里就得好好琢磨该怎么友好提示给用户了.如果请求用户服务失败，返回什么信息给消费者客户端
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("后端不可用".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return httpHeaders;
            }
        };
    }
}

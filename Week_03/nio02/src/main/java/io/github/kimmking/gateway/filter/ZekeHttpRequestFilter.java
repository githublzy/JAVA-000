package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @Class ZekeHttpRequestFilter
 * @Description ZekeHttpRequestFilter
 * @Author zeke
 * @Date 8/11/2020 12:19 下午
 * @Version 1.0.0
 **/
public class ZekeHttpRequestFilter implements HttpRequestFilter {
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        String uri = fullRequest.uri();
        System.out.println("uri: " + uri);
        fullRequest.headers().set("name","zekek");
        fullRequest.headers().set("token","fdsakjfhakohefiubcnzkdsbf");
    }
}
